import java.util.*;
class GraphWithAdjacencyList {
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
    public void DFS(int key){
        HashSet<GraphNode> visited = new HashSet<>();
        LinkedList<GraphNode> stack = new LinkedList<>();
        stack.addFirst(listIndex.get(key));
        visited.add(listIndex.get(key));
        while (stack.size() != 0){
            GraphNode temp = stack.removeFirst();
            System.out.print(temp.data+"\t");
            for(GraphNode val : getAdjNodes(temp.data)){
                if(!(visited.contains(val))){
                    stack.addFirst(val);
                    visited.add(val);
                }
            }
        }
    }
    public void BFS(int key){
        HashSet<GraphNode> visited = new HashSet<>();
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.addLast(listIndex.get(key));
        visited.add(listIndex.get(key));
        while (queue.size() != 0){
            GraphNode temp = queue.removeFirst();
            visited.add(temp);
            System.out.print(temp.data+"\t");
            for(GraphNode val : getAdjNodes(temp.data)){
                if(!visited.contains(val)){
                    queue.addLast(val);
                    visited.add(val);
                }
            }
        }
    }
    public static class GraphNode {
        public int data;
        GraphNode(int data) {
          this.data = data;
        }
      }
      public static void main(String[] args) {
        GraphWithAdjacencyList test = new GraphWithAdjacencyList();
        test.addNode(7);
        test.addNode(2);
        test.addNode(4);
        test.addNode(6);
        test.addNode(0);
        test.addEdge(7, 4);
        test.addEdge(7, 2);
        test.addEdge(2, 4);
        test.addEdge(2, 0);
        test.addEdge(4, 6);
        test.addEdge(6, 0);
        test.DFS(0);
      }
      
}
