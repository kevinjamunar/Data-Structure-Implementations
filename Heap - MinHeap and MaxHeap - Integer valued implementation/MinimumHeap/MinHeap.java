package Heap.MinimumHeap;

public class MinHeap{

    private HeapNode[] minHeap;
    private int size = -1; //non-negative integer represents index of the last element in the heap.

    public MinHeap(int heapSize){
        this.minHeap = new HeapNode[heapSize];
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
        minHeap[size] = heapNode;
        siftUp(size);
    }
    /*
        removes the minimum element from the heap
        and reorders it such that it satisfies all
        the properties of a Min Heap.
     */
    public HeapNode removeMinimum(){
        //swap the top of the heap with the last element in the heap & remove the last element
        HeapNode temp = minHeap[size];
        minHeap[size] = minHeap[0];
        minHeap[0] = temp;
        minHeap[size] = null;
        size--;

        siftDown();
        return temp;
    }

    /*
        compares the value at index 'key' to its parent's value.
        If the child's value is less than its parent's, then
        parent and child pointers are swapped.

        This condition stops when the parent's value is smaller
        than its child's value.
     */
    private void siftUp(int key){
        int keyValue = minHeap[key].getValue();
        int parentKey = getParentKey(key);
        int parentValue = minHeap[parentKey].getValue();

        while(parentValue > keyValue){
            // swap pointers
            HeapNode tempNode = minHeap[parentKey];
            minHeap[parentKey] = minHeap[key];
            minHeap[key] = tempNode;

            //update key and parent key
            key = parentKey;
            parentKey = getParentKey(key);
            parentValue = minHeap[parentKey].getValue();
            keyValue = minHeap[key].getValue();
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
        //if there is no right child, swap pointers if left child is smaller.
        if(rightChildKey < 0){
            if(minHeap[leftChildKey].getValue() < minHeap[key].getValue()){
                HeapNode temp = minHeap[leftChildKey];
                minHeap[leftChildKey] = minHeap[key];
                minHeap[key] = temp;
            }
            return;
        }
        //if there are 2 children
        int smallerChildKey = leftChildKey;
        if(minHeap[rightChildKey].getValue() < minHeap[leftChildKey].getValue()){
            smallerChildKey = rightChildKey;
        }

        while(minHeap[key].getValue() > minHeap[smallerChildKey].getValue()){
            // swap pointers
            HeapNode temp = minHeap[smallerChildKey];
            minHeap[smallerChildKey] = minHeap[key];
            minHeap[key] = temp;

            //update parent key and child keys
            key = smallerChildKey;
            leftChildKey = getLeftChildKey(key);
            rightChildKey = getRightChildKey(key);

            //if there is no left child, return.
            if(leftChildKey < 0){
                break;
            }
            //if there is no right child, swap pointers if left child is smaller.
            if(rightChildKey < 0){
                if(minHeap[leftChildKey].getValue() < minHeap[key].getValue()){
                    temp = minHeap[leftChildKey];
                    minHeap[leftChildKey] = minHeap[key];
                    minHeap[key] = temp;
                }
                break;
            }

            //if there are 2 children
            key = smallerChildKey;
            smallerChildKey = leftChildKey;
            if(minHeap[rightChildKey].getValue() < minHeap[leftChildKey].getValue()){
                smallerChildKey = rightChildKey;
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
        for(HeapNode heapNode: minHeap){
            if(heapNode != null)
                System.out.print(heapNode.getValue() + " ");
        }
    }
}
