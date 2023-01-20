import app from './app.js'

app.listen(app.get('port'))

console.log('Server listening on port', app.get('port'))