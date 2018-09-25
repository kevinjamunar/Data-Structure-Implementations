package Heap.MinimumHeap;

public class MainHeap {

    public static void main(String[] args){

        MinHeap minHeap = new MinHeap(9);
        minHeap.addValue(3);
        minHeap.addValue(5);
        minHeap.addValue(7);
        minHeap.addValue(9);
        minHeap.addValue(11);
        minHeap.addValue(8);
        minHeap.addValue(1);
        minHeap.addValue(2);
        minHeap.addValue(6);
        minHeap.printHeap();
        System.out.println();
        minHeap.removeMinimum(); //remove min
        minHeap.printHeap();
        minHeap.removeMinimum(); //remove min
        System.out.println();
        minHeap.printHeap();
    }
}
