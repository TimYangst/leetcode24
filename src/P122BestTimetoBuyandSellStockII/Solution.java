package P122BestTimetoBuyandSellStockII;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int[] f = new int[prices.length];
        int[] g = new int[prices.length];
        if (prices[1] > prices[0]) {
            f[1] = prices[1] - prices[0];
            g[1] = f[1];
        }

        for (int i = 2; i < prices.length; i++) {
            int maxPro = 0;
            for (int j = i - 1; j >= 0; j--) {
                int tmp = prices[i] - prices[j];
                if (j > 0)
                    tmp += g[j - 1];
                if (tmp > maxPro)
                    maxPro = tmp;
            }
            f[i] = maxPro;
            g[i] = Math.max(g[i - 1], f[i]);
        }
        return g[prices.length - 1];
    }
}
