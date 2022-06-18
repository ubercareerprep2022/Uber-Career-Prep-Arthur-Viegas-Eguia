public class Tree {
    public TreeNode root;
  
    public Tree(TreeNode root) {
      this.root = root;
    }
  
    public static void main(String[] args) {
      TreeNode leftChild = new TreeNode(6, null, null);
      TreeNode rightChild = new TreeNode(3, null, null);
      TreeNode left = new TreeNode(7, null, null);
      TreeNode right = new TreeNode(17, leftChild, rightChild);
      TreeNode root = new TreeNode(1, left, right);
      Tree tree = new Tree(root);
      print(root);
    }

    public static void print(TreeNode root){
      System.out.print(root.data);
      if(root.left != null){
        print(root.left);
      }
      if(root.right != null){
        print(root.right);
      }
    }

    public static class TreeNode {
      public int data;
      public TreeNode left;
      public TreeNode right;
  
      public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
      }
    }
}