import java.util.*;
class Exercise5 {
    private Map<GraphNode, List<GraphNode>> adjNodes = new HashMap<>();
    private Map<Integer, GraphNode> listIndex = new HashMap<>();
    public void addNode(int key) {
        GraphNode v = new GraphNode(key);
        adjNodes.put(v, new LinkedList<GraphNode>());
        listIndex.put(key, v);
    }
    public void removeNode(int key){
        adjNodes.remove(listIndex.get(key));
        listIndex.remove(key);
    }
    public void addEdge(int node1, int node2){
        GraphNode n1 = listIndex.get(node1);
        GraphNode n2 = listIndex.get(node2);
        adjNodes.get(n1).add(n2);
        adjNodes.get(n2).add(n1);
    }
    void removeEdge(int node1, int node2){
        GraphNode n1 = listIndex.get(node1);
        GraphNode n2 = listIndex.get(node2);
        adjNodes.remove(n1);
        adjNodes.remove(n2);
        listIndex.remove(node1);
        listIndex.remove(node2);
    }
    List<GraphNode> getAdjNodes(int key){
        return adjNodes.get(listIndex.get(key));
    }
    public void printHash(HashMap<GraphNode, GraphNode> hash){
        for(GraphNode thiss : hash.keySet()){
            System.out.println(thiss.data);
        }
    }
    public void printEdge(){
        for(GraphNode i : getAdjNodes(0)){
            System.out.println(i.data);
        }
    }
    public int minNumberOfEdges(int node1, int node2){
        HashMap<GraphNode, GraphNode> visited = new HashMap<>();
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.addLast(listIndex.get(node1));
        visited.put(listIndex.get(node1), new GraphNode(-1));
        while (queue.size() != 0){
            GraphNode temp = queue.removeFirst();
            for(GraphNode val : getAdjNodes(temp.data)){
                if(!(visited.get(val) != null)){
                    queue.addLast(val);
                    visited.put(val, temp);
                }
            }
        }
        if(visited.get(listIndex.get(node2)) == null) return -1;
        GraphNode curr = listIndex.get(node2);
        int i = 0;
        while(curr != listIndex.get(node1)){
            i++;
            curr = visited.get(curr);
        }
        return i;
    }
    public static class GraphNode {
        public int data;
        GraphNode(int data) {
          this.data = data;
        }
      }
      public static void main(String[] args) {
        Exercise5 test = new Exercise5();
        test.addNode(0);
        test.addNode(1);
        test.addNode(2);
        test.addNode(3);
        test.addNode(4);
        test.addNode(5);
        test.addNode(6);
        test.addEdge(0, 4);
        test.addEdge(0, 2);
        test.addEdge(0, 1);
        test.addEdge(1, 2);
        test.addEdge(2, 5);
        test.addEdge(3, 4);
        test.addEdge(4, 6);
        System.out.println(test.minNumberOfEdges(6, 1));
      }
      
}
