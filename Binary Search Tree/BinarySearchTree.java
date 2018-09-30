package BinarySearchTree;

public class BinarySearchTree{

    private BinaryTreeNode root;

    public BinarySearchTree(int rootKey) {
        this.root = new BinaryTreeNode(rootKey);
    }
    /*
        returns the root of the tree.
     */
    public BinaryTreeNode getRoot(){
        return this.root;
    }

    /*
        searches for the node whose instance variable key is equal to the argument key.
        Returns the node if found, or null otherwise.
     */
    public BinaryTreeNode search(int key, BinaryTreeNode root) {
        BinaryTreeNode ptr = root;
        while(ptr != null){
            if(key == ptr.getKey()){
                return ptr;
            }
            else if(key < ptr.getKey()){
                ptr = ptr.getLeftChild();
            }
            else if(key > ptr.getKey()){
                ptr = ptr.getRightChild();
            }
        }
        return null;
    }

    /*
        inserts a node with value key to the tree.
     */
    public void insert(Integer key, BinaryTreeNode root){
        if(root == null){
            this.root = new BinaryTreeNode(key);
        }
        else{
            BinaryTreeNode ptr = root;
            BinaryTreeNode newNode = new BinaryTreeNode(key);
            while(ptr != null){

                //case 1: argument key is < the key currently pointed to.
                if(key.compareTo(ptr.getKey()) < 0){
                    if(ptr.getLeftChild() == null) {
                        newNode.setParent(ptr);
                        ptr.setLeftChild(newNode);
                        return;
                    }
                    ptr = ptr.getLeftChild();
                }

                //case 2: argument key is > the key currently pointed to.
                else if(key.compareTo(ptr.getKey()) > 0){
                    if(ptr.getRightChild() == null){
                        newNode.setParent(ptr);
                        ptr.setRightChild(newNode);
                        return;
                    }
                    ptr = ptr.getRightChild();
                }

                else { //case 3: if data is the same, update instance count.
                    ptr.incrementCount();
                }
            }
        }
    }

    /*
        returns the node with the smallest key in the tree or null o/w.
     */
    public BinaryTreeNode findMin(BinaryTreeNode root){
        if(root == null)
            return null;

        BinaryTreeNode ptr = root;
        while(ptr.getLeftChild() != null){
            ptr = ptr.getLeftChild();
        }
        return ptr;
    }

    /*
        returns the node with the biggest key in the tree or null o/w.
     */
    public BinaryTreeNode findMax(BinaryTreeNode root){
        if(root == null)
            return null;

        BinaryTreeNode ptr = root;
        while(ptr.getRightChild() != null){
            ptr = ptr.getRightChild();
        }
        return ptr;
    }

    /*
        returns the node whose instance variable key is immediately smaller than the argument key.
        Returns null if there is no predecessor to the argument key.
     */
    public BinaryTreeNode findPredecessor(Integer key, BinaryTreeNode root){
        if(root == null){
            return null;
        }
        BinaryTreeNode ptr;
        ptr = search(key,root); //finds the node with value key.

        //key does not exist
        if(ptr == null){
            return null;
        }

        //case 1: the node with value key has a left subtree:
        //find the Max value in that subtree
        if (ptr.getLeftChild() != null){
            ptr = ptr.getLeftChild();
            return findMax(ptr);
        }

        //case 2: the node with value key has NO left subtree:
        //find first left parent(first parent with value < key)
        while(ptr.getParent() != null){
            if(ptr.getParent().getKey() < key){
                return ptr.getParent();
            }
            ptr = ptr.getParent();
        }
        return null;
    }

    /*
        returns the node whose instance variable key is immediately bigger than the argument key.
        Returns null if there is no successor to the argument key.
     */
    public BinaryTreeNode findSuccessor(Integer key, BinaryTreeNode root){
        if(root ==  null){
            return null;
        }
        BinaryTreeNode ptr;
        ptr = search(key, root); //finds the node with value key.

        //key does not exist
        if(ptr == null){
            return null;
        }

        //case 1: the node with value key has a right subtree:
        //find the Min value in that subtree.
        if(ptr.getRightChild() != null){
            ptr = ptr.getRightChild();
            return findMin(ptr);
        }

        //case 2: the node with value key has NO right subtree:
        //find the first right parent(first parent with value > key)
        while(ptr.getParent() != null){
            if(ptr.getParent().getKey() > key){
                return ptr;
            }
            ptr = ptr.getParent();
        }
        return null;
    }

    public boolean delete(Integer key, BinaryTreeNode root){
        if(root == null){
            return false;
        }

        BinaryTreeNode ptr = search(key,root);
        BinaryTreeNode parent = ptr.getParent();

        //case 1: node has no children
        if(ptr.getLeftChild() == null && ptr.getRightChild() == null){
            if(parent.getRightChild().getKey() == key){
                parent.setRightChild(null);
                return true;
            }
            parent.setLeftChild(null);
            return true;
        }

        //case 2: node has at most one child.

        //node only has a left child.
        else if(ptr.getLeftChild() != null && ptr.getRightChild() == null){
            if(parent.getLeftChild().getKey() == key){
                parent.setLeftChild(ptr.getLeftChild());
                return true;
            }
            parent.setRightChild(ptr.getLeftChild());
            return true;
        }
        //node only has a right child.
        else if(ptr.getLeftChild() == null && ptr.getRightChild() != null){
            if(parent.getLeftChild().getKey() == key){
                parent.setLeftChild(ptr.getRightChild());
                return true;
            }
            parent.setRightChild(ptr.getRightChild());
            return true;
        }

        //case 3: node has exactly two children.
        else{
            BinaryTreeNode predecessorOfKey = findPredecessor(key, ptr);
            int temp = predecessorOfKey.getKey();
            predecessorOfKey.setKey(ptr.getKey());
            ptr.setKey(temp);
            delete(key,predecessorOfKey); //delete the anomaly via a recursive call.
            return true;
        }
    }

    /*
        prints an inorder representation of the tree.
     */
    public void printBinarySearchTree(BinaryTreeNode root){
        if(root == null){
            return;
        }
        printBinarySearchTree(root.getLeftChild());
        System.out.print(root.getKey() + "\t");
        printBinarySearchTree(root.getRightChild());
    }
}
