package Heap.MaximumHeap;

public class MainHeap {

    public static void main(String[] args){

        MaxHeap maxHeap = new MaxHeap(9);
        maxHeap.addValue(3);
        maxHeap.addValue(5);
        maxHeap.addValue(7);
        maxHeap.addValue(9);
        maxHeap.addValue(11);
        maxHeap.addValue(8);
        maxHeap.addValue(1);
        maxHeap.addValue(2);
        maxHeap.addValue(6);
        maxHeap.printHeap();
        System.out.println();
        maxHeap.removeMaximum(); //remove max
        maxHeap.printHeap();
        maxHeap.removeMaximum(); //remove max
        System.out.println();
        maxHeap.printHeap();
    }
}
