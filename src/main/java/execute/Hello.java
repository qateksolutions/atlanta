package execute;

import binaryTree.BinaryTree;
import binaryTree.Node;
import practice.*;

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

public class Hello {
//    enum LEVEL {
//        LOW,
//        MEDIUM,
//        HIGH
//    }

    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
//
//        System.out.println("PreOrder value of the binary tree is:");
//        tree.printTreeValue();

        Pig objPig = new Pig();
        objPig.animalSound();
        objPig.sleep();
    }
}
