import java.util.HashMap;

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
        if(index > this.size() || index < 0){
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
     * Returns the element in the specified position of the list
     * @param index the index which will have its element returned
     * @return the element in position index, null if not in bounds
     */
    public Node elementAt(int index){
        if(index > this.size() || index < 0){
            return null;
        }
        Node iterate = firstNode;
        for(int i = 0; i < index; i++){
            iterate = iterate.nextNode;
        }
        return iterate;
        
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
        Node iterate = firstNode;
        Node nodeBefore = firstNode;
        if(firstNode != null) {
            if(firstNode.nextNode != null){
                iterate = iterate.nextNode;
            }
            else{
                firstNode = null;
                return iterate;
            }
            while(iterate.nextNode != null){
                iterate = iterate.nextNode;
                nodeBefore = nodeBefore.nextNode;
            }
            nodeBefore.nextNode = null;
            return iterate;
        }
        return null;
    }
    /**
     * Erases the linkedlist.
     */
    public void erase(){
        if(firstNode != null){
            firstNode = null;
        }
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
     * Detects whether the list has a cycle.
     * @return true if a cycle is found; false otherwise
     */
    public boolean hasCycle(){
        HashMap<Node, Boolean> cycle = new HashMap<>();
        Node iterate = firstNode;
        while(iterate != null){
            if(cycle.containsKey(iterate)){
                return true;
            }
            else{
                cycle.put(iterate, true);
            }
            iterate = iterate.nextNode;
        }
        return false;
    }

    /**
     * Prints the Linked List
     */
    public String printList(){
        Node iterate = firstNode;
        String nodes = "";
        while(iterate != null){
            nodes += iterate.value+"    ";
            iterate = iterate.nextNode;
        }
        return nodes;
    }

}