import express from 'express'










// const server = require("./server");
// const kafka = require("./kafka");
// const logger = require("./logger");
// const db = require("./database");

// class App {
//   async start() {
//     try {
//       // Connect to Kafka
//       await kafka.connect();
//       logger.info("Connected to Kafka cluster");

//       // Check database connection
//       await db.checkConnection();
//       logger.info("Connected to to the database");

//       await await server.listen({
//         port: process.env.SERVER_PORT,
//         host: "0.0.0.0", // Default is 127.0.0.1, to be avoided because it refuses connections from other containers or from the main host
//       });
//       logger.info(`Server listening on port ${process.env.SERVER_PORT}`);
//     } catch (error) {
//       logger.error("ERROR: " + error.message);
//       process.exit(1);
//     }
//   }
// }

// module.exports = App;