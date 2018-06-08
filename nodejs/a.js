// var http = require('http');

// http.createServer(function (req, res) {
//     console.log("hello! server started and listening");
//     res.writeHead(200, {'Content-Type': 'text/html'});
//     res.end('Hello World!');
// }).listen(8080);




fs = require('fs');

var line_read;
fs.readFile('/test.txt', 'utf8', function (err,data) {
  if (err) {
    return console.log(err);
  }
  console.log(data);
  line_read = data[0];
});

console.log("Hello World");
var line_read = "1 2 5 6 -1 8 11";
var lines  = line_read.split(" ");
// ["1", "2", "5", "6", "-1", "8", "11"];

function Node (key) {
    this.key = key;
    this.left = null;
    this.right = null;
}

function printPostOrder(root) {
        if (root !== null) {

            // First recur on left child
            printPostOrder(root.left);

            // the recur on right child
            printPostOrder(root.right);

            // now print the data of node
            // result.Add(root.key);
            // Console.WriteLine(root.key);
            console.log(root.key);
}
}

function getNode(treeArray, index) {
        if ((2 * index + 1 >= treeArray.length) || (2 * index + 2 >= treeArray.length) || (index >= treeArray.length)) {
            return new Node(treeArray[index]);
        }
        var tempNode = new Node(treeArray[index]);

        tempNode.left = getNode(treeArray, 2 * index + 1);

        tempNode.right = getNode(treeArray, 2 * index + 2);

        return tempNode;
}

var node = getNode(lines, 0);
printPostOrder(node);
