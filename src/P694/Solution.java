package P694;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    static int[] DN = { 0, 1, 0, -1, 0 };

    String travel(int[][] grid, int x, int y) {
        StringBuilder sb = new StringBuilder();
        sb.append("1,");
        int tot = 1;
        Queue<int[]> queue = new LinkedList<>();
        grid[x][y] = -grid[x][y];
        queue.add(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0];
            int j = current[1];
            int v = -grid[i][j];
            for (int k = 0; k < 4; k++) {
                int nx = i + DN[k];
                int ny = j + DN[k + 1];
                if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length
                        && grid[nx][ny] > 0) {
                    tot++;
                    sb.append(v).append("-").append(k).append(',');
                    grid[nx][ny] = -tot;
                    queue.add(new int[] { nx, ny });
                }
            }
        }
        return sb.toString();
    }

    public int numDistinctIslands(int[][] grid) {
        Set<String> seq = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    seq.add(travel(grid, i, j));
                }
            }
        }
        return seq.size();
    }
}