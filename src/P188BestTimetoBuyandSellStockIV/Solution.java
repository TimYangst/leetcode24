package P188BestTimetoBuyandSellStockIV;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0)
            return 0;

        int[] sells = new int[k];
        int[] buys = new int[k];

        for (int i = 0; i < k; i++) {
            sells[i] = 0;
            buys[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                int initialValue = (j == 0) ? 0 : sells[j - 1];
                buys[j] = Math.max(buys[j], initialValue - prices[i]);
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
            }
        }
        return sells[k - 1];
    }
}
