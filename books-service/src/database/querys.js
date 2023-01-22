export const queries = {
  getAllBooks: 'SELECT * FROM book',
  getBookById: 'SELECT * FROM book WHERE id = @id',
  createNewBook: 'INSERT INTO book (Name, Author) VALUES (@Name, @Author)',
  deleteBookById: 'DELETE FROM book WHERE id = @id',
  updateBookById: 'UPDATE book SET Name = @Name, Author = @Author WHERE id = @id',
}