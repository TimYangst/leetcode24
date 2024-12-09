package P827;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    static int[] delta = { 0, 1, 0, -1, 0 };

    private int gfs(int x, int y, int k, int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        int size = 0;
        grid[x][y] = k;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + delta[i];
                int ny = current[1] + delta[i + 1];
                if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length
                        && grid[nx][ny] == 1) {
                    grid[nx][ny] = k;
                    queue.offer(new int[] { nx, ny });
                }
            }
        }
        return size;
    }

    public int largestIsland(int[][] grid) {
        int w = grid.length;
        int h = grid[0].length;
        if (w == 1 && h == 1)
            return 1;
        int k = 2;
        Map<Integer, Integer> size = new HashMap<>();
        int result = 1;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (grid[i][j] == 1) {
                    int current = gfs(i, j, k, grid);
                    size.put(k, current);
                    if (current > result)
                        result = current;
                    k++;
                }
            }
        }
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (grid[i][j] == 0) {
                    int current = 1;
                    Set<Integer> closeTo = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int nx = i + delta[d];
                        int ny = j + delta[d + 1];
                        if (0 <= nx && nx < w && 0 <= ny && ny < h) {
                            if (grid[nx][ny] != 0)
                                closeTo.add(grid[nx][ny]);
                        }
                    }
                    for (int index : closeTo)
                        current += size.get(index);
                    if (current > result)
                        result = current;
                }
            }
        }
        return result;
    }
}