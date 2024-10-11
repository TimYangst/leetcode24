package P188BestTimetoBuyandSellStockIV;

class Solution {

    private int trySolve(int index, int canBuyAStock, int[][][] dp, int[] prices, int capacity) {
        if (capacity == 0 || index == prices.length)
            return 0;
        if (dp[index][canBuyAStock][capacity] != -1)
            return dp[index][canBuyAStock][capacity];

        if (canBuyAStock == 1) {
            dp[index][canBuyAStock][capacity] = Math.max(
                    -prices[index] + trySolve(index + 1, 0, dp, prices, capacity),
                    trySolve(index + 1, 1, dp, prices, capacity));
        } else {
            dp[index][canBuyAStock][capacity] = Math.max(
                    prices[index] + trySolve(index + 1, 1, dp, prices, capacity - 1),
                    trySolve(index + 1, 0, dp, prices, capacity));
        }
        return dp[index][canBuyAStock][capacity];
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1 || k == 0)
            return 0;
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int l = 0; l <= k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return trySolve(0, 1, dp, prices, k);
    }
}