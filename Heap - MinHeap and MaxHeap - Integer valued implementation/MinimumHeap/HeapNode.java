package Heap.MinimumHeap;

public class HeapNode {

    private int value; //data associated with each HeapNode

    public HeapNode(int value){
        this.value=value;
    }
    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value=value;
    }
}
