import {Router} from "express";

import {createBook, getBookById, getBooks, deleteBookById, updateBookById} from '../controllers/books.controller'

const router = Router()

// Get all books
router.get('/books', getBooks)

// Get one books
router.get('/books/:id', getBookById)

// Create a new book
router.post('/books', createBook)

// Update a book
router.put('/books/:id', updateBookById)

// Delete a book
router.delete('/books/:id', deleteBookById)


export default router