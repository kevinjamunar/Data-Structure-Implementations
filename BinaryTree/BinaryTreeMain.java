import BinaryTree.BinaryTree;
import BinaryTree.BinaryTreeNode;

public class BinaryTreeMain {

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>(10);


        binaryTree.getRoot().setLeftChild(new BinaryTreeNode<>(11));
        binaryTree.getRoot().setRightChild(new BinaryTreeNode<>(9));
        binaryTree.printBinaryTree(binaryTree.getRoot());


        binaryTree.removeLeftChild(binaryTree.getRoot());
        binaryTree.removeRightChild(binaryTree.getRoot());
        binaryTree.printBinaryTree(binaryTree.getRoot());
    }
}
