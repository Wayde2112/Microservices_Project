import sql from 'pg';

// Credenziali database
const dbSettings = {
  user: 'postgres', 
  password: 'postgres',
  host: 'localhost',
  database: 'book',
  port: 5433,
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
