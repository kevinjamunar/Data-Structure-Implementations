package Heap.MaximumHeap;

public class MaxHeap {

    private HeapNode[] maxHeap;
    private int size = -1; //non-negative integer represents index of the last element in the heap.

    public MaxHeap(int heapSize){
        this.maxHeap = new HeapNode[heapSize];
    }
    /*
        Inserts a value at the next free position in the heap.
        This keeps the heap perfectly balanced.
        All position adjustments to the key are done via 'siftUp'
        O(log n)
     */
    public void addValue(int value){
        HeapNode heapNode = new HeapNode(value);
        size++;
        maxHeap[size] = heapNode;
        siftUp(size);
    }
    /*
        removes the maximum element from the heap
        and reorders it such that it satisfies all
        the properties of a Max Heap.
     */
    public HeapNode removeMaximum(){
        //swap the top of the heap with the last element in the heap & remove the last element
        HeapNode temp = maxHeap[size];
        maxHeap[size] = maxHeap[0];
        maxHeap[0] = temp;
        maxHeap[size] = null;
        size--;

        siftDown();
        return temp;
    }

    /*
        compares the value at index 'key' to its parent's value.
        If the child's value is more than its parent's, then
        parent and child pointers are swapped.

        This condition stops when the parent's value is bigger
        than its child's value.
     */
    private void siftUp(int key){
        int keyValue = maxHeap[key].getValue();
        int parentKey = getParentKey(key);
        int parentValue = maxHeap[parentKey].getValue();

        while(parentValue < keyValue){
            // swap pointers
            HeapNode tempNode = maxHeap[parentKey];
            maxHeap[parentKey] = maxHeap[key];
            maxHeap[key] = tempNode;

            //update key and parent key
            key = parentKey;
            parentKey = getParentKey(key);
            parentValue = maxHeap[parentKey].getValue();
            keyValue = maxHeap[key].getValue();
        }
    }

    private void siftDown(){
        int key = 0;
        int leftChildKey = getLeftChildKey(key);
        int rightChildKey = getRightChildKey(key);

        //if there is no left child, return.
        if(leftChildKey < 0){
            return;
        }
        //if there is no right child, swap pointers if left child is bigger.
        if(rightChildKey < 0){
            if(maxHeap[leftChildKey].getValue() > maxHeap[key].getValue()){
                HeapNode temp = maxHeap[leftChildKey];
                maxHeap[leftChildKey] = maxHeap[key];
                maxHeap[key] = temp;
            }
            return;
        }
        //if there are 2 children
        int biggerChild = leftChildKey;
        if(maxHeap[rightChildKey].getValue() > maxHeap[leftChildKey].getValue()){
            biggerChild = rightChildKey;
        }

        while(maxHeap[key].getValue() < maxHeap[biggerChild].getValue()){
            // swap pointers
            HeapNode temp = maxHeap[biggerChild];
            maxHeap[biggerChild] = maxHeap[key];
            maxHeap[key] = temp;

            //update parent key and child keys
            key = biggerChild;
            leftChildKey = getLeftChildKey(key);
            rightChildKey = getRightChildKey(key);

            //if there is no left child, return.
            if(leftChildKey < 0){
                break;
            }
            //if there is no right child, swap pointers if left child is bigger.
            if(rightChildKey < 0){
                if(maxHeap[leftChildKey].getValue() > maxHeap[key].getValue()){
                    temp = maxHeap[leftChildKey];
                    maxHeap[leftChildKey] = maxHeap[key];
                    maxHeap[key] = temp;
                }
                break;
            }
            //if there are 2 children
            key = biggerChild;
            biggerChild = leftChildKey;
            if(maxHeap[rightChildKey].getValue() > maxHeap[leftChildKey].getValue()){
                biggerChild = rightChildKey;
            }
        }
    }

    /*
       accepts a key(index to the heap) and returns that key's parent.
     */
    private int getParentKey(int key){
        return key/2;
    }
    /*
       Accepts a key(index to the heap) and returns that key's left child.
       If the key does not have a left child, return -1.
     */
    private int getLeftChildKey(int key){
        int leftChildKey = (key*2)+1;
        if(leftChildKey > size){
            return -1;
        }
        return leftChildKey;
    }
    /*
       Accepts a key(index to the heap) and returns that key's right child.
       If the key does not have a right child, return -1.
     */
    private int getRightChildKey(int key){
        int rightChildKey = (key*2)+2;
        if(rightChildKey > size){
            return -1;
        }
        return rightChildKey;
    }
    /*
        returns true if the heap is empty and false otherwise.
     */
    public boolean isEmpty() {
        return size == -1;
    }
    /*
        returns the current number of elements in the heap.
     */
    public int getSize(){
        return this.size;
    }

    /*
        prints the heap in an array format.
     */
    public void printHeap(){
        for(HeapNode heapNode: maxHeap){
            if(heapNode != null)
                System.out.print(heapNode.getValue() + " ");
        }
    }
}
