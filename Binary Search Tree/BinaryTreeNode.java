package BinarySearchTree;

public class BinaryTreeNode implements Comparable<BinaryTreeNode> {

    private Integer key;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;
    private BinaryTreeNode parent;
    private int count;

    public BinaryTreeNode(int key){
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    public int getKey(){
        return this.key;
    }
    public void setKey(int key){
        this.key = key;
    }
    public BinaryTreeNode getLeftChild(){
        return this.leftChild;
    }
    public void setLeftChild(BinaryTreeNode leftChild){
        this.leftChild = leftChild;
    }
    public BinaryTreeNode getRightChild(){
        return this.rightChild;
    }
    public void setRightChild(BinaryTreeNode rightChild){
        this.rightChild = rightChild;
    }

    public BinaryTreeNode getParent(){
        return this.parent;
    }
    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }
    public int getCount(){
        return this.count;
    }
    public void incrementCount(){
        this.count++;
    }

    @Override
    public int compareTo(BinaryTreeNode btn) {
        return this.key.compareTo(btn.getKey());
    }
}
