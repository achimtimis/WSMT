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
            treeArray = Files.readAllLines(Paths.get(testFilePath)).get(1);
        } catch (Exception e) {
        }
        String[] nodes = treeArray.split(" ");
        node = getNode(nodes, 0);
        printPostorder(node);

    }

    public static Node getNode(String[] treeArray, int index) {
        if ((2 * index + 1 >= treeArray.length) || (2 * index + 2 >= treeArray.length) || (index >= treeArray.length)) {
            return new Node(treeArray[index]);
        }
        node = new Node(treeArray[index]);
        node.setLeft(getNode(treeArray, 2 * index + 1));
        node.setRight(getNode(treeArray, 2 * index + 2));
        return node;
    }

    // A function to do postorder tree traversal
    public static void printPostorder(Node root) {
        if (root != null) {

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