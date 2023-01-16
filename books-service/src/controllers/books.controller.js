import { getConnection, sql, queries } from '../database'

// Get all books
export const getBooks = async (req, res) => {

  try {
    const pool = await getConnection()
    const result = await pool
      .request()
      .query(queries.getAllBooks)
  
    res.json(result.recordset) 
    console.log("GetBooks successfully done")   
  } catch (error) {
    res.status(500)
    res.send(error.message)
  }

}

// Get one book by id
export const getBookById = async (req, res) => {

  try {
    const { id } = req.params
  
    const pool = await getConnection()
    const result = await pool
      .request()
      .input('Id', id)
      .query(queries.getBookById)
  
    console.log(id)
  
    res.send(result.recordset[0])
  } catch (error) {
    
  }
}  

// Create a new book
export const createBook = async (req, res) => {
  
  const { Name, Author } = req.body
  
  if (Name == null || Author == null) {
    return res.status(400)
    .json({ msg: 'Invalid Request. Fill all fields'})
  }

  try {
    const pool = await getConnection()
    
    await pool.request()
      .input("Name", sql.VarChar, Name)
      .input("Author", sql.VarChar, Author)
      .query(queries.createNewBook)
  
    console.log(Name,Author)
    
    res.json({Name, Author})    
  } catch (error) {
    res.status(500)
    res.send(error.message)
  }

}

// Delete one book by id
export const deleteBookById = async (req, res) => {
  const { id } = req.params

  const pool = await getConnection()
  const result = await pool
    .request()
    .input('Id', id)
    .query(queries.deleteBookById)

  res.sendStatus(204)
}  

// Update one book by id
export const updateBookById = async (req, res) => {

  const { Name, Author } = req.body
  const { id } = req.params

  if ((Name == null || Author == null)) {
    return res.status(400).json({ msg: 'Bad request. Please fill all fields' })
  }

  const pool = await getConnection()
  await pool.request()
      .input("Id", sql.Int, id)
      .input("Name", sql.VarChar, Name)
      .input("Author", sql.VarChar, Author)
      .query(queries.updateBookById)

  res.json({ Name, Author })
}  