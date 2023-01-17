const express = require('express')
const kafka = require('kafka-node')
const app = express()
const mongoose = require('mongoose')
app.use(express.json())

const dbsAreRunning = async () => {
    mongoose.connect(process.env.MONGO_URL)
    const User = new mongoose.model('user', {
        name: String,
        email: String,
        password: String
    })
    const client = new kafka.KafkaClient({kafkaHost: process.env.KKAFKA_BOOTSTRAP_SERVERS})
    const consumer = new kafka.Consumer(client, [{topic: process.env.KAFKA_TOPIC }], 
        {
        autoCommit: false
        })
    consumer.on('message', async (message) => {
        const user = await new User(JSON.parse(message,value))
        await user.save()
    }
    )
    consumer.on('error', (err) => {
        console.log(err)
    }
    )
}
setTimeout(dbsAreRunning, 10000)


app.listen(process.env.PORT)