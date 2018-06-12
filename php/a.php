<?php
class Node {
    private $key;
    private $left;
    private $right;

    public function __construct() {
    
    }

    public function __get($property) {
      if (property_exists($this, $property)) {
        return $this->$property;
      }
    }
  
    public function __set($property, $value) {
      if (property_exists($this, $property)) {
        $this->$property = $value;
      }
  
      return $this;
    }
  }
// var_dump($argv);
// $filename = $argv[1];
$fh = fopen('/mnt/c/linux/wsmt-5programs/test.txt','r');
$tree = fgets($fh);
$treeArray = explode(" ", $tree);
print_r($treeArray);

fclose($fh);
$result = array();
echo "array count " . count($treeArray) . "\n";
$root = getNode($treeArray, 0);
printPostorder($root);


function getNode($treeArray, $index) {

    if ((((2 * $index) + 1) >= count($treeArray)) || (((2 * $index) + 2) >= count($treeArray)) || ($index >= count($treeArray))) {
        $tempnode2 = new Node();
        $tempnode2->key = $treeArray[$index];
        return $tempnode2;
    }
    if ($treeArray[$index] == "-1"){
      $tempnode2 = new Node();
      $tempnode2->key = $treeArray[$index];
      return $tempnode2;
    }
    $tempNode = new Node();
    $tempNode->key = $treeArray[$index];
    // echo "node key  " . $treeArray[$index] . "\n";
    // echo "node key2 " . $tempNode->key . "\n";
    $tempNode->left = getNode($treeArray, (2 * $index) + 1);
    $tempNode->right = getNode($treeArray, (2 * $index) + 2);
    return $tempNode;
}

 function printPostorder($root) {
    if ($root != null && $root->key != "-1") {

        // First recur on left child
        printPostorder($root->left);

        // the recur on right child
        printPostorder($root->right);

        // now print the data of node
        //array_push($result, $root->key);
        // Console.WriteLine(root.key);
        echo 'result key ' . $root->key . "\n";
    }
}
?>