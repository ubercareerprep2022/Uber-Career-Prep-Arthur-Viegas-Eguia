public class BinarySearchTreePhoneBook implements PhoneBook {
    private Node root;
    private int size = 0;
  
    public int size(){
        return size;
    }

    public void insert(String name, long number) {
      if(root == null){
        root = new Node();
        root.name = name;
        root.number = number;
        size++;
        return;
      }
      Node current = root;
      while(true){
        if(current.name.compareTo(name) >= 0){
            if(current.left == null){
                current.left = new Node();
                current.left.name = name;
                current.left.number = number;
                size++;
                break;
            }
            else{
                current = current.left;
            }
        }
        else{
            if(current.right == null){
                current.right = new Node();
                current.right.name = name;
                current.right.number = number;
                size++;
                break;
            }
            else{
                current = current.right;
            }
        }
      }
    }

    public long find(String name) {
      Node current = root;
      while(current != null){
        if(current.name.equals(name)){
            return current.number;
        }
        else if(current.name.compareTo(name) > 0){
            current = current.left;
        }
        else{
            current = current.right;
        }
      }
      return -1;
    }
    public static void main(String[] args) {
        BinarySearchTreePhoneBook test = new BinarySearchTreePhoneBook();
        test.insert("a", 1);
        System.out.println(test.size());
        test.insert("b", 2);
        test.insert("c", 3);
        System.out.println(test.size());
        System.out.println(test.find("a"));
        System.out.println(test.find("b"));
        System.out.println(test.find("c"));
        System.out.println(test.find("d"));
    }
    public static class Node {
      public String name;
      public long number;
      public Node left;
      public Node right;
    }
}

