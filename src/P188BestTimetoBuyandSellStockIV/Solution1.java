package P188BestTimetoBuyandSellStockIV;

class Solution1 {

    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1 || k == 0)
            return 0;
        int n = prices.length;
        int[][] f = new int[k + 1][n + 1];
        int minV = prices[0];
        for (int i = 1; i < n; i++) {
            if (minV > prices[i]) {
                minV = prices[i];
            }
            f[0][i] = Math.max(f[0][i - 1], prices[i] - minV);
        }

        for (int j = 1; j < k; j++) {
            f[j][1] = f[j - 1][1];
            for (int i = 2; i < n; i++) {
                f[j][i] = Math.max(f[j - 1][i], f[j][i - 1]);
                for (int l = 1; l < i; l++) {
                    f[j][i] = Math.max(f[j][i], (prices[i] - prices[l]) + f[j - 1][l - 1]);
                }
            }
        }
        return f[k - 1][n - 1];
    }
}