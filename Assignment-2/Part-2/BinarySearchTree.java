public class BinarySearchTree {
    private Node root;
  
    /**
     * Inserts a key into this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method should be log(n).
     * 
     * @param key The key to insert.
     */
    public void insert(int key) {
      if(root == null){
        root = new Node();
        root.key = key;
        return;
      }
      Node current = root;
      while(true){
        if(current.key >= key){
            if(current.left == null){
                current.left = new Node();
                current.left.key = key;
                break;
            }
            else{
                current = current.left;
            }
        }
        else{
            if(current.right == null){
                current.right = new Node();
                current.right.key = key;
                break;
            }
            else{
                current = current.right;
            }
        }
      }
    }
  
    /**
     * Checks whether or not a key exists in this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method should be log(n).
     * 
     * @param key The key to check for.
     * @return true if the key is present in this binary search tree, false otherwise.
     */
    public boolean find(int key) {
      Node current = root;
      while(current != null){
        if(current.key == key){
            return true;
        }
        else if(current.key > key){
            current = current.left;
        }
        else{
            current = current.right;
        }
      }
      return false;
    }
  
    public static class Node {
      public int key;
      public Node left;
      public Node right;
    }
}
  
