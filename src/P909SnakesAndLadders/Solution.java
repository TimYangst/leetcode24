package P909SnakesAndLadders;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Cell {
        int x = 0;
        int y = 0;

        public Cell() {
        }

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int snakesAndLadders(int[][] board) {
        if (board.length <= 1)
            return 0;
        int n = board.length;
        int[] visited = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            visited[i] = -1;
        }
        visited[0] = 0;
        int end = n * n - 1;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        while (!queue.isEmpty() && visited[end] == -1) {
            int current = queue.poll();
            int next;
            for (int i = 1; i <= 6; i++) {
                if (current + i <= end + 1) {
                    next = current + i;
                    Cell nextC = getCoord(n, next);
                    if (board[nextC.x][nextC.y] != -1) {
                        next = board[nextC.x][nextC.y];
                    }
                    if (visited[next - 1] == -1) {
                        queue.add(next);
                        visited[next - 1] = visited[current - 1] + 1;
                    }
                }
            }
        }
        return visited[end];
    }

    Cell getCoord(int n, int index) {
        Cell result = new Cell();
        int r = (index - 1) / n;
        result.x = n - r - 1;
        if (r % 2 == 0) {
            result.y = (index - 1) % n;
        } else {
            result.y = n - (index - 1) % n - 1;
        }
        return result;
    }
}