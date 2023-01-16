export const queries = {
  getAllBooks: 'SELECT * FROM Book',
  getBookById: 'SELECT * FROM Book WHERE id = @id',
  createNewBook: 'INSERT INTO Book (Name, Author) VALUES (@Name, @Author)',
  deleteBookById: 'DELETE FROM Book WHERE id = @id',
  updateBookById: 'UPDATE Book SET Name = @Name, Author = @Author WHERE id = @id',
}