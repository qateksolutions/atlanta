package binaryTree;

/* Java Program to traverse a binary tree
 input:
         1
        / \
       2   3
      / \
     4   5
Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
*/

public class BinaryTree {
    public Node root;

    public BinaryTree() {
        root = null;
    }

    private void printPreOrder(Node node) {
        if (node == null) {
            return;
        }
        // Print data of node
        System.out.print(node.key + " ");
        // then recursion on left subtree
        printPreOrder(node.left);
        // then recursion on right subtree
        printPreOrder(node.right);
    }

    public void printTreeValue() {
        printPreOrder(root);
    }
}
