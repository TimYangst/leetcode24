package P695;

class Solution {
    static int[] DN = { 0, 1, 0, -1, 0 };

    int dfs(int[][] grid, int x, int y) {
        int result = 1;
        for (int k = 0; k < 4; k++) {
            int nx = x + DN[k];
            int ny = y + DN[k + 1];
            if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length
                    && grid[nx][ny] == 1) {
                grid[nx][ny] = -1;
                result += dfs(grid, nx, ny);
            }
        }
        return result;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    int area = dfs(grid, i, j);
                    if (area > result)
                        result = area;
                }
            }
        }
        return result;
    }
}