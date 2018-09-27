package BinaryTree;

/*
    Simple Node for a Binary Tree
 */
public class BinaryTreeNode<T> {

    private T data;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public T getData(){
        return this.data;
    }
    public void setData(T data){
        this.data = data;
    }
    public BinaryTreeNode<T> getLeftChild(){
        return this.leftChild;
    }
    public void setLeftChild(BinaryTreeNode<T> leftChild){
        this.leftChild = leftChild;
    }
    public BinaryTreeNode<T> getRightChild(){
        return this.rightChild;
    }
    public void setRightChild(BinaryTreeNode<T> rightChild){
        this.rightChild = rightChild;
    }

}
