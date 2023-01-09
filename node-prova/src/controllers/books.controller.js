import {getConnection, sql} from '../database/connection'

export const getBooks = async (req, res) => {

  const pool = await getConnection()
  const result = await pool.request().query('SELECT * FROM Book')
  console.log(result)

  res.json(result.recordset)

}

export const createBook = async (req, res) => {
  
  const { Name, Author } = req.body

  if (Name == null || Author == null) {
    return res.status(400)
      .json({ msg: 'Invalid Request. Fill all fields'})
  }

  await getConnection().request().input("Name", sql.VarChar, 'Test')

  console.log(Name,Author)

  res.json('new book')
}
