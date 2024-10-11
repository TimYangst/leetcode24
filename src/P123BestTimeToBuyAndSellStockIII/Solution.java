package P123BestTimeToBuyAndSellStockIII;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int f[] = new int[prices.length + 1];
        int g[] = new int[prices.length + 1];

        int currentMin = prices[0];
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < currentMin) {
                currentMin = prices[i];
            }
            f[i] = Math.max(f[i - 1], prices[i] - currentMin);
        }
        int currentMax = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > currentMax) {
                currentMax = prices[i];
            }
            g[i] = Math.max(g[i + 1], currentMax - prices[i]);
        }
        result = g[0];
        for (int i = 2; i < prices.length; i++) {
            result = Math.max(result, f[i - 1] + g[i]);
        }
        return result;
    }
}