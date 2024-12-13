package P200NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = new int[] { 0, 1, 0, -1 };
    int[] dy = new int[] { -1, 0, 1, 0 };

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void bfs(char[][] grid, int x, int y) {
        Queue<Integer> xQueue = new LinkedList<Integer>();
        Queue<Integer> yQueue = new LinkedList<Integer>();
        xQueue.add(x);
        yQueue.add(y);
        grid[x][y] = '0';
        while (!xQueue.isEmpty()) {
            int i = xQueue.poll();
            int j = yQueue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = i + dx[k];
                int newY = j + dy[k];
                if (0 <= newX && newX < grid.length && 0 <= newY && newY < grid[0].length
                        && grid[newX][newY] == '1') {
                    grid[newX][newY] = '0';
                    xQueue.add(newX);
                    yQueue.add(newY);
                }
            }
        }
    }
}