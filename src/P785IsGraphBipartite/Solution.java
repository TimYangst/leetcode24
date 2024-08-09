package P785IsGraphBipartite;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private boolean tryToBipart(int current, Set<Integer> visited, Set<Integer> taggedNode, int[][] graph) {
        visited.add(current);
        boolean isTagged = taggedNode.contains(current);
        for (int i = 0; i < graph[current].length; i++) {
            int next = graph[current][i];
            if (visited.contains(next)) {
                if (!(taggedNode.contains(next) ^ isTagged)) return false;
            } else {
                if (!isTagged) {
                    taggedNode.add(next);
                }
                if (!tryToBipart(next, visited, taggedNode, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        if (graph.length <= 2) return true;
        Set<Integer> taggedNode = new HashSet<> (); 
        Set<Integer> visited = new HashSet<> ();
        for (int i = 0; i < graph.length; i++) {
            if (!visited.contains(i)) {
                taggedNode.add(i);
                if (!tryToBipart(i, visited, taggedNode, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
}