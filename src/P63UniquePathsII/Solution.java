package P63UniquePathsII;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int xl = obstacleGrid.length;
        int yl = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[xl - 1][yl - 1] == 1)
            return 0;
        int f[][] = new int[xl][yl];
        f[0][0] = 1;
        for (int i = 1; i < xl; i++) {
            if (obstacleGrid[i][0] == 0) {
                f[i][0] = f[i - 1][0];
            }
        }
        for (int j = 1; j < yl; j++) {
            if (obstacleGrid[0][j] == 0) {
                f[0][j] = f[0][j - 1];
            }
        }
        for (int i = 1; i < xl; i++) {
            for (int j = 1; j < yl; j++) {
                if (obstacleGrid[i][j] == 0) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[xl - 1][yl - 1];
    }
}
