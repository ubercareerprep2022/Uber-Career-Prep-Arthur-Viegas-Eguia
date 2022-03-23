public class Queue<T>{
    private Node firstNode = null;
    private Node lastNode = null;
    private class Node{
        private T value;
        private Node nextNode;
        private Node previousNode = null;
        Node(T value, Node nextNode){
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    /**
     * Adds an element to the rear of the queue
     * @param value an object of type T, to be added to the rear of the queue
     */
    public void enqueue(T value) {
        if(firstNode == null){
            lastNode = new Node(value, null);
            firstNode = lastNode;
        }
        else {
            Node nodeToAdd = new Node(value, lastNode);
            lastNode.previousNode = nodeToAdd;
            lastNode = nodeToAdd;
        }
    }

    /**
     * Returns the element on the front of the queue, or null if empty
     * @return the element on the front of the queue, or null if empty
     */
    public T front(){
        if(this.firstNode != null){
            return firstNode.value;
        }
        return null;
    }
    
    /**
     * Returns the element on the rear of the queue, or null if empty
     * @return the element on the rear of the queue, or null if empty
     */
    public T rear(){
        if(this.lastNode != null){
            return lastNode.value;
        }
        return null;
    }

    /**
     * Returns whether the queue is empty
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return firstNode == null;
    }

    /**
    * Returns and removes the element on the front of the queue
    * @return the element on the front of the queue, or null if it is empry
    */

    public T dequeue(){
        if(firstNode != null) {
            T returnValue = firstNode.value;
            firstNode = firstNode.previousNode;
            return returnValue;
        }
        return null;
    }

    /**
     * Returns the size of the queue
     * @return an integer, representing the size of the queue
     */
    public int size(){
        Node iterate = firstNode;
        int i = 0;
        while(iterate != null){
            i++;
            iterate = iterate.previousNode;
        }
        return i;
    }
}
