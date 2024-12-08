package P688;

import java.util.Arrays;

class Solution {
    int[] dx = { 1, 2, 1, -2, -1, 2, -1, -2 };
    int[] dy = { 2, 1, -2, 1, 2, -1, -2, -1 };

    private double helper(int k, int x, int y, double[][][] dp, int n) {
        if (x < 0 || x >= n || y < 0 || y >= n)
            return 0.0;
        if (dp[x][y][k] > -0.9)
            return dp[x][y][k];
        if (k == 0)
            return 1.0;
        double ans = 0.0;
        for (int i = 0; i < 8; i++) {
            ans += (1.0 / 8) * helper(k - 1, x + dx[i], y + dy[i], dp, n);
        }
        dp[x][y][k] = ans;
        return ans;
    }

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[26][26][101];
        for (var a : dp) {
            for (var b : a) {
                Arrays.fill(b, -1);
            }
        }

        return helper(k, row, column, dp, n);
    }
}