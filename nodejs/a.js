var http = require('http');

http.createServer(function (req, res) {
    console.log("hello! server started and listening");
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end('Hello World!');
}).listen(8080);