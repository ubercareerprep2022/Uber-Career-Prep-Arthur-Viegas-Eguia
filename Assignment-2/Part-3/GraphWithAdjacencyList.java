import java.util.*;
class GraphWithAdjacencyList {
    private Map<Integer, List<Integer>> adjNodes = new HashMap<>();
    public void addNode(int key) {
        adjNodes.put(key, new LinkedList<Integer>());
    }
    public void removeNode(int key){
        adjNodes.remove(key);
    }
    public void addEdge(int node1, int node2){
        adjNodes.get(node1).add(node2);
    }
    void removeEdge(int node1, int node2){
        adjNodes.remove(Integer.valueOf(2));
    }
    List<Integer> getAdjNodes(int key){
        return adjNodes.get(key);
    }
    public List<Integer> depthFirtst(int key){
        HashMap<Integer, Boolean> visited = new HashMap<>();
        LinkedList<Integer> arr = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        arr.addFirst(key);
        while (arr.size() != 0){
            int temp = arr.removeFirst();
            path.add(temp);
            visited.put(temp, true);
            for(int val : getAdjNodes(temp)){
                if(visited.get(temp) != null){
                    arr.addFirst(val);
                }
            }
        }
        return path;
    }
    public List<Integer> bredthFirtst(int key){
        HashMap<Integer, Boolean> visited = new HashMap<>();
        LinkedList<Integer> arr = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        arr.addLast(key);
        while (arr.size() != 0){
            int temp = arr.removeFirst();
            path.add(temp);
            visited.put(temp, true);
            for(int val : getAdjNodes(temp)){
                if(visited.get(temp) != null){
                    arr.addLast(val);
                }
            }
        }
        return path;
    }
}
