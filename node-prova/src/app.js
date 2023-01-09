import express from 'express'
import config from './config'

import booksRoutes from './routes/books.routes'

const app = express()

// Settings
app.set('port', config.port)

// Middlewares
app.use(express.json())
app.use(express.urlencoded({ extended: false}))

// Routes
app.use(booksRoutes)

export default app