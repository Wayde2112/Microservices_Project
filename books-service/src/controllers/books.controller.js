import { connection } from '../database/connectionmysql.js'
import { queries } from '../database/querys.js'

// Get all books
export const getBooks = async (req, res) => {
  
  var time = new Date().getTime()
  
  try {
    // const pool = await getConnection()
    const result = connection
    .query(queries.getAllBooks)

    res.json(result.recordset)

    console.log("GetBooks successfully done " + (new Date().getTime() - time) + " ms")   
  } catch (error) {
    res.status(500)
    res.send(error.message)
  }

}

// Get one book by id
export const getBookById = async (req, res) => {

  var time = new Date().getTime()

  try {
    const { id } = req.params
  
    // const pool = await getConnection()
    const result = connection
      .request()
      .input('Id', id)
      .query(queries.getBookById)
    
  
    console.log("GetBookById successfully done " + (new Date().getTime() - time) + " ms")
  
    res.send(result.recordset[0])
  } catch (error) {
    
  }
}  

// Create a new book
export const createBook = async (req, res) => {

  var time = new Date().getTime()
  
  const { Name, Author } = req.body
  
  if (Name == null || Author == null) {
    return res.status(400)
    .json({ msg: 'Invalid Request. Fill all fields'})
  }

  try {
    // const pool = await getConnection()
    
    const result = connection.request()
      .input("Name", sql.VarChar, Name)
      .input("Author", sql.VarChar, Author)
      .query(queries.createNewBook)
  
    console.log("CreateBook successfully done " + (new Date().getTime() - time) + " ms")

    res.json({Name, Author})    
  } catch (error) {
    res.status(500)
    res.send(error.message)
  }

}

// Delete one book by id
export const deleteBookById = async (req, res) => {

  var time = new Date().getTime()
  const { id } = req.params

  // const pool = await getConnection()
  const result = connection
    .request()
    .input('Id', id)
    .query(queries.deleteBookById)

  res.sendStatus(204)
  console.log("DeleteBookById successfully done " + (new Date().getTime() - time) + " ms")
}  

// Update one book by id
export const updateBookById = async (req, res) => {

  var time = new Date().getTime()
  const { Name, Author } = req.body
  const { id } = req.params

  if ((Name == null || Author == null)) {
    return res.status(400).json({ msg: 'Bad request. Please fill all fields' })
  }

  // const pool = await getConnection()
  connection.request()
      .input("Id", sql.Int, id)
      .input("Name", sql.VarChar, Name)
      .input("Author", sql.VarChar, Author)
      .query(queries.updateBookById)

  res.json({ Name, Author })
  console.log("UpdateBookById successfully done " + (new Date().getTime() - time) + " ms")
}  