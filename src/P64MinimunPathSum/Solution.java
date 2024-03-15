package P64MinimunPathSum;

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int x = grid.length;
        int y = grid[0].length;
        int f[][] = new int[x][y];
        f[0][0] = grid[0][0];
        for (int i = 1; i < x; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < y; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                f[i][j] = grid[i][j];
                if (f[i - 1][j] < f[i][j - 1])
                    f[i][j] += f[i - 1][j];
                else
                    f[i][j] += f[i][j - 1];
            }
        }
        return f[x - 1][y - 1];
    }
}
