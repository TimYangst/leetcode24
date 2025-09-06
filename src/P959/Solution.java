package P959;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] DN = { -1, 0, 1, 0, -1 };

    public int regionsBySlashes(String[] grid) {
        boolean[][][] map = new boolean[grid.length][grid[0].length()][4];
        int h = grid.length;
        int w = grid[0].length();

        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!map[i][j][d]) {
                        result++;
                        map[i][j][d] = true;

                        wfs(new int[] { i, j, d }, map, grid);
                    }
                }
            }
        }
        return result;
    }

    void wfs(int[] loc, boolean[][][] map, String[] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(loc);
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int i = current[0];
            int j = current[1];
            int k = current[2];
            System.out.println(i + " " + j + " " + k);
            char c = grid[i].charAt(j);
            switch (c) {
                case ' ':
                    for (int l = 0; l < 4; l++) {
                        if (!map[i][j][l]) {
                            map[i][j][l] = true;
                            queue.add(new int[] { i, j, l });
                        }
                    }
                    break;
                case '/':
                    if (!map[i][j][3 - k]) {
                        map[i][j][3 - k] = true;
                        queue.add(new int[] { i, j, 3 - k });
                    }
                    break;
                case '\\':
                    int t = 1;
                    if (k > 1)
                        t = 5;
                    if (!map[i][j][t - k]) {
                        map[i][j][t - k] = true;
                        queue.add(new int[] { i, j, t - k });
                    }
                    break;
                default:
                    break;
            }

            int nx = i + DN[k];
            int ny = j + DN[k + 1];
            if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length()) {
                int nd = 0;
                if (k % 2 == 0) {
                    nd = 2 - k;
                } else
                    nd = 4 - k;
                if (!map[nx][ny][nd]) {
                    map[nx][ny][nd] = true;
                    queue.add(new int[] { nx, ny, nd });
                }
            }
        }
    }
}
