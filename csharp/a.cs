using System;
using System.Collections;
using System.Collections.Generic;
namespace HelloWorld
{
    public class Hello 
    {

        public static Node node;
        public static List<string> result = new List<string>();

        public class Node {
        public Node(String key){ this.key = key; }
        public Node left { get; set; }
        public Node right { get; set; }
        public String key { get; set; }
        
        }
        
        static void Main() 
        {
            Console.WriteLine("Hello World!");

            // Keep the console window open in debug mode.
            string[] treeArray = System.IO.File.ReadAllLines(@"C:\linux\wsmt-5programs\test.txt");
            Console.WriteLine("read line: " + String.Join("\n", treeArray[0]));
            Console.WriteLine("[{0}]", string.Join("", treeArray[0].Split(' ')));
            string[] nodes = treeArray[0].Split(' ');
            Console.WriteLine("end of reading file");
            node = getNode(nodes, 0);
            printPostorder(node);
            Console.WriteLine("Result is");
            Console.WriteLine(string.Join(" ", result.ToArray()));

        }

        public static Node getNode(string[] treeArray, int index) {
        if ((2 * index + 1 >= treeArray.Length) || (2 * index + 2 >= treeArray.Length) || (index >= treeArray.Length)) {
            return new Node(treeArray[index]);
        }
        if (treeArray[index].Equals("-1")){
            return new Node(treeArray[index]);
        }
        Node tempNode = new Node(treeArray[index]);

        tempNode.left = getNode(treeArray, 2 * index + 1);

        tempNode.right = getNode(treeArray, 2 * index + 2);

        return tempNode;
    }

        public static void printPostorder(Node root) {
        if (root != null && !root.key.Equals("-1")) {

            // First recur on left child
            printPostorder(root.left);

            // the recur on right child
            printPostorder(root.right);

            // now print the data of node
            result.Add(root.key);
            // Console.WriteLine(root.key);
        }
    }
    }
}
