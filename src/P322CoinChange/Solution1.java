package P322CoinChange;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution1 {

    public int coinChange(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        Arrays.sort(coins);

        int[] f = new int[amount + 1];
        Queue<Integer> queue = new LinkedList<>();
        int step = 0;
        queue.offer(0);
        while (!queue.isEmpty()) {
            step++;
            int k = queue.size();
            for (int i = 0; i < k; i++) {
                int current = queue.poll();
                for (int j = coins.length - 1; j >= 0; j--) {
                    if (coins[j] > amount)
                        continue;
                    if (current == amount - coins[j])
                        return step;
                    if (current + coins[j] < amount && f[current + coins[j]] == 0) {
                        queue.offer(current + coins[j]);
                        f[current + coins[j]] = step;
                    }
                }
            }
        }
        return -1;
    }
}
