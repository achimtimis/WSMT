import java.nio.file.*;
import java.util.*;

public class A {

    private static final String testFilePath = "/mnt/c/linux/wsmt-5programs/test.txt";
    public static Node node;
    public static List<String> result = new ArrayList();

    static class Node {
        private Node left;
        private Node right;
        private String key;

        public Node(String key) {
            this.key = key;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String key) {
            this.key = key;
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String treeArray = "";
        try {
            treeArray = Files.readAllLines(Paths.get(testFilePath)).get(0);
        } catch (Exception e) {
        }
        String[] nodes = treeArray.split(" ");
        node = getNode(nodes, 0);
        printPostorder(node);

    }

    public static Node getNode(String[] treeArray, int index) {
        if (((2 * index + 1) >= treeArray.length) || ((2 * index + 2) >= treeArray.length) || (index >= treeArray.length)) {
            return new Node(treeArray[index]);
        }
        if (treeArray[index].equals("-1")){
            return new Node(treeArray[index]);
        }
        Node tempNode = new Node(treeArray[index]);

        // if (!String.valueOf(treearray[2 * index + 1]).equals("-1")){
            tempNode.setLeft(getNode(treeArray, 2 * index + 1));

        // } else if (!String.valueOf(treearray[2 * index + 2]).equals("-1")){
            tempNode.setRight(getNode(treeArray, 2 * index + 2));

        // }
        return tempNode;
    }

    // A function to do postorder tree traversal
    public static void printPostorder(Node root) {
        if (root != null && !root.getKey().equals("-1")) {

            // First recur on left child
            printPostorder(root.getLeft());

            // the recur on right child
            printPostorder(root.getRight());

            // now print the data of node
            result.add(root.getKey());
            System.out.println(root.getKey());
        }
    }

    private static void runTests() {

    }
}