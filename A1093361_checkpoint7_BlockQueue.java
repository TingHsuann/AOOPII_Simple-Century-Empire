import java.util.*;

public class A1093361_checkpoint7_BlockQueue implements A1093361_checkpoint7_Fringe {
    Queue<A1093361_checkpoint7_Block> queue;

    // Description : the constuctor of BlockQueue.
    public A1093361_checkpoint7_BlockQueue() {
        // The TODO(4) This Time (Checkpoint7) : Initialize the queue.
        /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        // queue = new Queue<A1093361_checkpoint7_Block>();
        queue = new LinkedList<A1093361_checkpoint7_Block>();
        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/

    }

    // Description : add the input object into Fringe
    public void add(A1093361_checkpoint7_Block block) {
        // The TODO(4) This Time (Checkpoint7) : add block into the queue.
        /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        queue.offer(block);
        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/
    }

    // Description : return and remove the object from Fringe.
    public A1093361_checkpoint7_Block remove() {
        // The TODO(4) This Time (Checkpoint7) :First check the queue is empty or not
        // and return and remove the object from the queue.
        // If queue is empty return null.
        /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        if (!isEmpty()) {
            A1093361_checkpoint7_Block temp = queue.peek();
            queue.poll();
            return temp;
        }
        return null;
        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/

    }

    // Description : Check if the Fringe has a object at least. if it is empty
    // return true, vice versa.
    public boolean isEmpty() {
        // The TODO(4) This Time (Checkpoint7) :Check the queue is empty or not.
        /********************************************************************************************
         * START OF YOUR CODE
         ********************************************************************************************/
        if (queue.size() == 0) {
            return true;
        }
        return false;
        /********************************************************************************************
         * END OF YOUR CODE
         ********************************************************************************************/

    }
}