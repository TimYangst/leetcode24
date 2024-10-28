package P1091;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    private boolean isValidNode(Node node, int[][] grid) {
        if (node.x < 0 || node.y < 0 || node.x >= grid.length || node.y >= grid[0].length)
            return false;
        return grid[node.x][node.y] == 0;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1)
            return -1;
        if (grid.length == 1)
            return 1;
        grid[0][0] = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        Node next = new Node(current.x + i, current.y + j);
                        if (isValidNode(next, grid)) {
                            grid[next.x][next.y] = grid[current.x][current.y] - 1;
                            queue.add(next);
                            if (next.x == grid.length - 1 && next.y == grid.length - 1)
                                return -grid[next.x][next.y];
                        }
                    }
                }
            }
        }
        return -1;
    }
}