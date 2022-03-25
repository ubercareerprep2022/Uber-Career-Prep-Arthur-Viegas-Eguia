public class LinkedList{
    private Node firstNode = null;

    /**
     * Adds an element to the end of the Linked List
     * @param value the object of type T added to the end of the Linked List
     */
    public void push(Node node) {
        if(firstNode == null) {
            firstNode = node;
        }
        else {
            Node iterate = firstNode;
            for(int i = 0; i < size() - 1; i++){
                iterate = iterate.nextNode;
            }
            iterate.nextNode = node;
        }
    }

    /**
     * Adds an element to the a specific position on a Linked List
     * @param value the object of type T added to a spoecific position of a Linked List
     * @param index the position of the object in the linked list
     */
    public void insert(Node node, int index) {
        if(index > this.size()){
            return;
        }
        if(index == 0) {
            node.nextNode = firstNode;
            firstNode = node;
        }
        else {
            Node iterate = firstNode;
            for(int i = 0; i < index -1; i++){
                iterate = iterate.nextNode;
            }
            node.nextNode = iterate.nextNode;
            iterate.nextNode = node;
        }
    }

    /**
     * Removes an element from a specific position on a Linked List
     * @param value the object of type T added to a spoecific position of a Linked List
     */
    public void remove(int index) {
        int size = this.size();
        Node iterate = firstNode;
        if(index > size){
            return;
        }
        if(index == 0) {
            firstNode = firstNode.nextNode;
        }
        else if(index == size) {
            for(int i = 0; i < index -1; i++){
                iterate = iterate.nextNode;
            }
            iterate.nextNode = null;
        } 
        else {
            for(int i = 0; i < index -1; i++){
                iterate = iterate.nextNode;
            }
            Node tempNode = iterate.nextNode;
            iterate.nextNode = tempNode.nextNode;
        }
    }

    /**
    * Returns and removes the element on top of the Linked List
    * @return the element on top of the Linked List, or null if it is empty
    */

    public Node pop(){
        if(firstNode != null) {
            Node returnValue = firstNode;
            firstNode = firstNode.nextNode;
            return returnValue;
        }
        return null;
    }

    /**
     * Returns the size of the Linked List
     * @return an integer, representing the size of the Linked List
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

    /**
     * Prints the Linked List
     */
    public void printList(){
        Node iterate = firstNode;
        while(iterate != null){
            System.out.print(iterate.value+"    ");
            iterate = iterate.nextNode;
        }
        System.out.print("\n");
    }
}