package P122BestTimetoBuyandSellStockII;

class Solution1 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int result = 0;
        int currentLow = prices[0];
        int currentHigh = prices[0];
        int currentProfit = 0;
        for (int j = 1; j < prices.length; j++) {
            if (prices[j] > currentHigh) {
                currentHigh = prices[j];
                currentProfit = currentHigh - currentLow;
            } else {
                result += currentProfit;
                currentProfit = 0;
                currentLow = prices[j];
                currentHigh = prices[j];
            }
        }
        result += currentProfit;
        return result;
    }
}
