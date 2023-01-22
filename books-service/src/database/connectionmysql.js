// Importing module
import mysql from 'mysql'
  
export const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'password',
    database: 'book',
})
  
// Connecting to database & initializing
connection.connect(function(err) {
    if(err){
      console.log("Error in the connection with the database")
      console.log(err)
    }
    else{
      console.log(`Database Connected`)

      // Create table
      connection.query(`CREATE TABLE book(
        id SERIAL PRIMARY KEY,
        Name varchar(50),
        Author varchar(50),
        Stock integer);`, 
      function (err, result) {
        if(err)
          console.log(`Error executing the query - ${err}`)
        else
          console.log("Result: ",result) 
      })

      // Insert some book
      connection.query(`insert into book(Name, Author, Stock)
      values ('Fabio', 'Carello', 1),('Pierluigi', 'Italia', 4), 
             ('Fabio', 'Carello', 1),('Pierluigi', 'Italia', 4), 
             ('Fabio', 'Carello', 1),('Pierluigi', 'Italia', 4), 
             ('Fabio', 'Carello', 1),('Pierluigi', 'Italia', 4);`, 
      function (err, result) {
        if(err)
          console.log(`Error executing the query - ${err}`)
        else
          console.log("Result: ",result) 
      })
    }
})