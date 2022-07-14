import java.util.*;
class Exercise6 {
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
    }
    List<GraphNode> getAdjNodes(int key){
        return adjNodes.get(listIndex.get(key));
    }
    /**
     * @param numCourses integer representing the number of courses
     * @param prerequisites Array such that prerequisites[i] = [ai, bi]
     * indicates that you must take course bi first if you want to take course ai
     * @return true if possible to take all courses, false otherwise
     */
    public boolean DFS(int numCourses, ArrayList<Integer[]> prerequisites){
        Exercise6 graph = new Exercise6();
        for(int i = 0; i < numCourses; i++){
            graph.addNode(i);
        }
        for(Integer[] i : prerequisites){
            graph.addEdge(i[0], i[1]);
        }
        for(int i = 0; i < numCourses; i++){
            LinkedList<GraphNode> stack = new LinkedList<>();
            HashSet<GraphNode> visited = new HashSet<>();
            System.out.println(i);
            stack.addFirst(graph.listIndex.get(i));
            visited.add(graph.listIndex.get(i));
            while (stack.size() != 0){
                GraphNode temp = stack.removeFirst();
                for(GraphNode val : graph.getAdjNodes(temp.data)){
                    if(!(visited.contains(val))){
                        stack.addFirst(val);
                        visited.add(val);
                    }
                    else return false;
                }
            }
        }
        return true;
    }
    public static class GraphNode {
        public int data;
        GraphNode(int data) {
          this.data = data;
        }
      }

    public static void main(String[] args) {
        Exercise6 test = new Exercise6();
        ArrayList<Integer[]> prereqs = new ArrayList<>();
        prereqs.add(new Integer[]{1, 0});
        prereqs.add(new Integer[]{2,1});
        prereqs.add(new Integer[]{4, 2});
        prereqs.add(new Integer[]{2, 4});
        prereqs.add(new Integer[]{3, 2});
        prereqs.add(new Integer[]{3, 0});
        System.out.println(test.DFS(5, prereqs));
      }
      
}
