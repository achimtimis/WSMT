const fs = require('fs');

const readline = require('readline');
var line_read;
const rl = readline.createInterface({
    input: fs.createReadStream('/mnt/c/linux/wsmt-5programs/nodejs/test.txt')
});
rl.on('line', function (line) {
    line_read = line;
    console.log('Line from file:', line);
    var lines = line_read.split(' ');
    var node = getNode(lines, 0);
    printPostOrder(node);
});


function Node(key) {
    this.key = key;
    this.left = null;
    this.right = null;
}

function printPostOrder(root) {
    if (root !== null && root.key != "-1") {

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
    if (treeArray[index] === "-1"){
        return new Node(treeArray[index]);
    }
    var tempNode = new Node(treeArray[index]);

    tempNode.left = getNode(treeArray, 2 * index + 1);

    tempNode.right = getNode(treeArray, 2 * index + 2);

    return tempNode;
}
