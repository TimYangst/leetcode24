package P1466;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    class Node {
        int index;
        Set<Integer> in;
        Set<Integer> out;

        public Node(int i) {
            this.index = i;
            in = new HashSet<>();
            out = new HashSet<>();
        }
    }

    public int minReorder(int n, int[][] connections) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] path : connections) {
            nodes[path[0]].out.add(path[1]);
            nodes[path[1]].in.add(path[0]);
        }
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int in : nodes[current].in) {
                if (!visited[in]) {
                    visited[in] = true;
                    queue.add(in);
                }
            }
            for (int out : nodes[current].out) {
                if (!visited[out]) {
                    result++;
                    visited[out] = true;
                    queue.add(out);
                }
            }
        }
        return result;
    }
}
