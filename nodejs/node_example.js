var http = require("http");
http.createServer(function (request, response) {
    // Scrie headere HTTP Status: 200 si Content Type: text/plain
    response.writeHead(200, {'Content-Type': 'text/plain'});
    // Trimite la client corpul raspunsului
    response.end('Hello World\n');
}).listen(9999);  // Serverul web va astepta la portul 9999
// Se va tipari un mesaj pe consola serverului
console.log('Server running at http://localhost:9999/');    