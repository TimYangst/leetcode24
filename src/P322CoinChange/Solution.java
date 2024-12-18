package P322CoinChange;

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        int[] f = new int[amount + 1];
        Arrays.sort(coins);
        for (int j = coins.length - 1; j >= 0; j--) {
            if (coins[j] > amount)
                continue;
            f[coins[j]] = 1;
            for (int i = coins[j] + 1; i <= amount; i++) {
                if (f[i - coins[j]] > 0) {
                    f[i] = (f[i] == 0 ? f[i - coins[j]] + 1 : Math.min(f[i], f[i - coins[j]] + 1));
                }
            }
        }
        return f[amount] == 0 ? -1 : f[amount];
    }
}
