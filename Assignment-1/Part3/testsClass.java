public class testsClass {
    private LinkedList list = new LinkedList();
    public testsClass(){
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);
        Node<Integer> node5 = new Node<Integer>(5);
        Node<Integer> node6 = new Node<Integer>(6);
        Node<Integer> node7 = new Node<Integer>(7);
        Node<Integer> node8 = new Node<Integer>(8);
        Node<Integer> node9 = new Node<Integer>(9);
        Node<Integer> node10 = new Node<Integer>(10);
        list.push(node1);
        list.push(node2);
        list.push(node3);
        list.push(node4);
        list.push(node5);
        list.push(node6);
        list.push(node7);
        list.push(node8);
        list.push(node9);
        list.push(node10);
    }
    public void testEraseRemovesCorrectNode(){
        list.printList();
        list.erase();
        list.printList();
    }
    public void testElementAtReturnNode(){
        System.out.println(list.printList());
        System.out.println("Element at 0: "+list.elementAt(0).value);
        System.out.println("Element at 1: "+list.elementAt(1).value);
        System.out.println("Element at 3: "+list.elementAt(3).value);
        System.out.println("Element at 5: "+list.elementAt(5).value);
        System.out.println("Element at 8: "+list.elementAt(8).value);
        System.out.println("Element at 9: "+list.elementAt(9).value);
    }
    public void testEraseDoesNothingIfNoNode(){
        list.erase();
        list.printList();
    }
    public void testPushBackAddsOneNode(){
        System.out.println(list.printList());
        Node<Integer> nodeToAdd = new Node<>(11);
        list.push(nodeToAdd);
        System.out.println(list.printList());
    }
    public void testSizeReturnsCorrectSize(){
        System.out.println(list.printList());
        System.out.println("List Size: "+list.size());
        Node<Integer> nodeToAdd = new Node<>(11);
        list.push(nodeToAdd);
        System.out.println(list.printList());
        System.out.println("List Size: "+list.size());
        Node<Integer> nodeToAdd2 = new Node<>(12);
        list.push(nodeToAdd2);
        System.out.println(list.printList());
        System.out.println("List Size: "+list.size());

    }
    public void testPopBackRemovesCorrectNode(){
        System.out.println(list.printList());
        list.pop();
        System.out.println(list.printList());
    }
    public void testElementAtReturnsNoNodeIfIndexDoesNotExist(){
        System.out.println(list.printList());
        System.out.println("Negative: "+list.elementAt(-2));
        System.out.println("Out of bounds: "+list.elementAt(25));
    }
    public void hasCycle(){
        System.out.println(list.hasCycle());
        
    }
    public static void main(String[] args){
        testsClass tests = new testsClass();
        tests.testPushBackAddsOneNode();
        tests.testPopBackRemovesCorrectNode();
        tests.testElementAtReturnNode();
        tests.testElementAtReturnsNoNodeIfIndexDoesNotExist();
        tests.testSizeReturnsCorrectSize();
        tests.hasCycle();
        tests.testEraseRemovesCorrectNode();
        tests.testEraseDoesNothingIfNoNode();
    }
}
