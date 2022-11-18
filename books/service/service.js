const db = require("../database");
const { v4: uuidv4 } = require("uuid");
const logger = require("../logger");
const kafka = require("../kafka");

const getBooks = async () => {
  const allBooks = await db.select("*").from("book");
  logger.info(`GET /book`);
  return allBooks;
};

const getBook = async (id) => {
  logger.info(`GET /book/${id}`);
  const book = await db.select("*").from("book").where({ id }).first();
  return book;
};

const createBook = async (bookDTO) => {
  const newBook = {
    id: uuidv4(),
    ...bookDTO,
  };
  await db.insert(newBook).into("book");
  const logString = `New book created\n - id: ${newBook.id}\n - Title: ${newBook.title}\n - Author: ${newBook.author}`;
  logger.info(logString);

  // Send notification via kafka
  await kafka.publish(logString);
  return newBook;
};

const updateBook = async (id, updateBookDTO) => {
  const affectedRows = await db("book").where({ id }).update(updateBookDTO);
  const logString = `Book updated\n - id: ${id}\n - Title: ${updateBookDTO.title}\n - Author: ${updateBookDTO.author}`;
  logger.info(logString);

  // Send notification via kafka
  await kafka.publish(logString);
  return affectedRows;
};

const deleteBook = async (id) => {
  const logString = `DELETE /book/${id}`;
  logger.info(logString);
  const result = await db("book").where({ id }).del();

  // Send notification via kafka
  await kafka.publish(logString);
  return result;
};

module.exports = { getBooks, getBook, createBook, updateBook, deleteBook };
