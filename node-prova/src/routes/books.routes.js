import {Router} from "express";

import {createBook, getBooks} from '../controllers/books.controller'

const router = Router()

// Get all books
router.get('/books', getBooks)

// Get one books
router.get('/books',)

// Create a new book
router.post('/books', createBook)

// Update a book
router.put('/books', getBooks)

// Delete a book
router.delete('/books', getBooks)


export default router