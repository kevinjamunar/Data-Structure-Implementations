package BinaryTree;

public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTree(T rootData){
        root = new BinaryTreeNode<>(rootData);
    }

    /*
        returns the root of the Binary Tree
     */
    public BinaryTreeNode<T> getRoot(){
        return this.root;
    }
    /*
        sets the root to the argument passed in.
     */
    public void setRoot(BinaryTreeNode<T> root){
        this.root = root;
    }
    /*
        adds a left child to the argument BinaryTreeNode passed in.
     */
    public boolean addLeftChild(BinaryTreeNode<T> key, T leftChildData){
        if(key.getLeftChild() == null) {
            key.setLeftChild(new BinaryTreeNode<>(leftChildData));
            return true;
        }
        return false;
    }
    /*
        adds a right child to the argument BinaryTreeNode passed in.
     */
    public boolean addRightChild(BinaryTreeNode<T> key, T rightChildData){
        if(key.getRightChild() == null){
            key.setRightChild(new BinaryTreeNode<>(rightChildData));
            return true;
        }
        return false;
    }
    /*
        removes the left child of the argument BinaryTreeNode
     */
    public boolean removeLeftChild(BinaryTreeNode<T> key){
        if(key.getLeftChild() != null){
            key.setLeftChild(null);
            return true;
        }
        return false;
    }
    /*
        removes the right child of the argument BinaryTreeNode
     */
    public boolean removeRightChild(BinaryTreeNode<T> key){
        if(key.getRightChild() != null){
            key.setRightChild(null);
            return true;
        }
        return false;
    }

    /*
        prints the BinaryTree in an InOrder traversal format
     */
    public void printBinaryTree(BinaryTreeNode root){
        if(root == null){
            return;
        }
        printBinaryTree(root.getLeftChild());
        System.out.println(root.getData());
        printBinaryTree(root.getRightChild());
    }
}
