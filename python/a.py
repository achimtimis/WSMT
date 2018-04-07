import sys


result = [] #used for the tests
testFileLocation = "/mnt/c/linux/wsmt-5programs/test.txt"
 
class Node:
    def __init__(self,key):
        self.left = None
        self.right = None
        self.val = key
    def __repr__(self):
        return repr("left: " + str(self.left) + ", key: " + str(self.val) + ", right: " + str(self.right))
 
 


# A function to do postorder tree traversal
def printPostorder(root):
    if root:
 
        # First recur on left child
        printPostorder(root.left)
 
        # the recur on right child
        printPostorder(root.right)
 
        # now print the data of node
        result.append(root.val)
        print(root.val)


def getValue(value):

    if value:
        return value
    else:
        return None

def getNode(treeArray, index):
    if (2*index + 1 >= len(treeArray)) or (2*index + 2 >= len(treeArray)) or (index >= len(treeArray)):
            return Node(treeArray[index])
    node = Node(treeArray[index])
    node.left = getNode(treeArray, 2*index + 1)
    node.right = getNode(treeArray, 2*index + 2)
    return node


def runTests():
    result.clear()
    file = open(str(testFileLocation), "r")
    nodes = file.readlines()[1].split(" ")
    root = getNode(nodes, 0)
    printPostorder(root)
    print("result is " + str(result))
    assert result == ["2", "3\n", "1"]
    print("Unit tests ran sucessfully")
    

def main():
    runTests()
    result.clear()

    file = open(str(sys.argv[1]), "r") #/mnt/c/linux/wsmt-5programs/test.txt
    nodes = file.readlines()[0].split(" ")
    root = getNode(nodes, 0)
    print("the postorder values are: ")
    printPostorder(root)

main()
