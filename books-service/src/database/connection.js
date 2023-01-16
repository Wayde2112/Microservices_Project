import sql from 'mssql';

// Credenziali database
const dbSettings = {
  user: 'stefanito', 
  password: 'Stefanito',
  server: 'localhost',
  database: 'BooksDB',
  options: {
    encrypt: true,
    trustServerCertificate: true,
  },
}

// Funzione per collegarsi al database
export async function getConnection() {
  try {
    const pool = await sql.connect(dbSettings)
    return pool    
  } catch (error) {
    console.error(error)
  }
}

export {sql}
