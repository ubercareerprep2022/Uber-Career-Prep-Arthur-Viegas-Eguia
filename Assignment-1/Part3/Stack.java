public class Stack<T extends Comparable<T>>{
    private Node firstNode = null;
    private T minimumValue = null;
    private class Node{
        private T value;
        private Node nextNode;
        Node(T value, Node nextNode){
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    /**
     * Adds an element to the top of the stack
     * @param value an object of type T, to be added to the top of the stack
     */
    public void push(T value) {
        firstNode = new Node(value, firstNode);
        if(minimumValue == null || minimumValue.compareTo(value) > 0){
            minimumValue = value;
        }
    }

    public T returnMinimumValue(){
        return minimumValue;
    }

    /**
     * Returns the element on top of the stack, or null if empty
     * @return the element on top of the stack, or null if empty
     */
    public T top(){
        if(this.firstNode != null){
            return firstNode.value;
        }
        return null;
    }

    /**
     * Returns whether the stack is empty
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty(){
        return firstNode == null;
    }

    /**
    * Returns and removes the element on top of the stack
    * @return the element on top of the stack, or null if it is empry
    */

    public T pop(){
        if(firstNode != null) {
            T returnValue = firstNode.value;
            firstNode = firstNode.nextNode;
            return returnValue;
        }
        return null;
    }

    /**
     * Returns the size of the stack
     * @return an integer, representing the size of the stack
     */
    public int size(){
        Node iterate = firstNode;
        int i = 0;
        while(iterate != null){
            i++;
            iterate = iterate.nextNode;
        }
        return i;
    }
}
