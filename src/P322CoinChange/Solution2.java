package P322CoinChange;

import java.util.Arrays;

class Solution2 {

    private int search(int amount, int[] coins, int[] f) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (f[amount] != 0)
            return f[amount];
        f[amount] = -1;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] > amount)
                continue;
            int tryResult = search(amount - coins[i], coins, f);
            if (tryResult == -1)
                continue;
            f[amount] = (f[amount] == -1) ? (tryResult + 1) : Math.min(tryResult + 1, f[amount]);
        }
        return f[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        int[] f = new int[10001];
        Arrays.sort(coins);
        return search(amount, coins, f);
    }
}
