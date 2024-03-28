package P133CloneGraph;

// Definition for a Node.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> nodeMapping = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node result = new Node(node.val);
        nodeMapping.put(node, result);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node mapped = nodeMapping.get(current);
            for (Node next : current.neighbors) {
                Node mappedNext = null;
                if (!nodeMapping.containsKey(next)) {
                    mappedNext = new Node(next.val);
                    queue.add(next);
                    nodeMapping.put(next, mappedNext);
                } else {
                    mappedNext = nodeMapping.get(next);
                }
                mapped.neighbors.add(mappedNext);
            }
        }
        return result;
    }
}