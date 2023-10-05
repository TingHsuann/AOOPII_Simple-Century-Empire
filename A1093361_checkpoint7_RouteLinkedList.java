public class A1093361_checkpoint7_RouteLinkedList {
    private A1093361_checkpoint7_Node head;

    // Description : the constructor of leading the head Node as null.
    public A1093361_checkpoint7_RouteLinkedList() {
        this.head = null;
    }

    // Description : the constructor of input a Node as the head node.
    public A1093361_checkpoint7_RouteLinkedList(A1093361_checkpoint7_Node head) {
        this.head = head;
    }

    public void delete(int axis, int direction) {
        /*********************************
         * The TODO This Time (Checkpoint7)***************************
         * //TODO(7): Input value of Node as the reference Node,
         * // you have to delete the first Node that is same as the reference Node,
         * // and connect the following one and the previous one.
         * /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        // A1093361_checkpoint7_Node previousNode = head;
        // A1093361_checkpoint7_Node currentNode = head;
        // if (length() == 1) {
        // head = null;
        // }
        // while (previousNode.getNext() != null) {
        // previousNode = currentNode;
        // currentNode = currentNode.getNext();
        // if (currentNode.getAxis() == axis && currentNode.getDirection() == direction)
        // {
        // previousNode.setNext(currentNode.getNext());
        // currentNode.setNext(null);
        // }

        // }

        this.head = this.head.getNext();
        // return;

        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/
    }

    public A1093361_checkpoint7_Node search(int axis, int direction) {
        /*******************************
         * The TODO This Time (Checkpoint7)*****************************
         * //TODO(8): Input value of Node as the reference Node,
         * // you have to find the first Node that is same as the reference Node,
         * // and return it.
         * /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        A1093361_checkpoint7_Node searchNode = head;
        while (searchNode.getNext() != null) {
            searchNode = searchNode.getNext();
            if (searchNode.getAxis() == axis && searchNode.getDirection() == direction) {
                return searchNode;
            }
        }
        return searchNode;
        /****************************
         * searchNode****************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/
    }

    public void insert(int referenceAxis, int referenceDirection, int axis, int direction) {
        /******************************
         * The TODO This Time (Checkpoint7)******************************
         * //TODO(9): Input value of Node as the reference Node,
         * // and insert a Node BEFORE the first Node same as the reference Node,
         * // and connect the following one and the previous one.
         * //Hint The value of the Node is int variable axis and dirsction.
         * //Hint2 If there is no reference node in linkedlist, print "Insertion null".
         * /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        A1093361_checkpoint7_Node previousNode = head;
        A1093361_checkpoint7_Node currentNode = head;

        while (currentNode.getNext() != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            if (currentNode.getAxis() == axis && currentNode.getDirection() == direction) {
                A1093361_checkpoint7_Node newNode = new A1093361_checkpoint7_Node(direction, axis);
                previousNode.setNext(newNode);
                newNode.setNext(currentNode);
            }
        }
        System.out.println("Insertion null");
        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/
    }

    public int length() {
        /******************************
         * The TODO This Time (Checkpoint7)******************************
         * //TODO(10): return how long the LinkedList is.
         * /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        A1093361_checkpoint7_Node node = head;
        int count = 1;
        if (head == null) {
            return 0;
        }
        while (node.getNext() != null) {
            count++;
            node = node.getNext();
        }
        return count;
        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/
    }

    public void append(int axis, int direction) {
        A1093361_checkpoint7_Node current = head;
        A1093361_checkpoint7_Node newNode = new A1093361_checkpoint7_Node(direction, axis);
        if (head == null) {
            head = newNode;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public A1093361_checkpoint7_Node getHead() {
        return this.head;
    }

    public void setHead(A1093361_checkpoint7_Node head) {
        this.head = head;
    }
}
