package Top150.P121BestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
            else if (prices[i] < minPrice)
                minPrice = prices[i];
        }
        return maxProfit;
    }
}
