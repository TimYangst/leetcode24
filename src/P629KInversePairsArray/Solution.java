package P629KInversePairsArray;

class Solution {
    static int MOD = 1000000007;

    public int kInversePairs(int n, int k) {
        if (k == 0)
            return 1;
        int[][] f = new int[n + 2][k + 1];
        f[1][0] = 1;
        f[2][0] = 1;
        f[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            f[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                for (int l = Math.min(j, i - 1); l >= 0; l--) {
                    f[i][j] += f[i - 1][j - l];
                    f[i][j] %= MOD;
                }
            }
        }
        return f[n][k];
    }
}