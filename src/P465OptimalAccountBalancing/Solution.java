package P465OptimalAccountBalancing;

class Solution {

    int search(int[] balance, int index, int nextIndex, int maxIndex) {
        if (balance[index] == 0) {
            if (index < maxIndex)
                return search(balance, index + 1, index + 2, maxIndex);
            return 0;
        }
        if (nextIndex > maxIndex)
            return Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = nextIndex; i <= maxIndex; i++) {
            if (balance[i] * balance[index] < 0) {
                int amount = Math.min(Math.abs(balance[index]), Math.abs(balance[i]));
                int nextResult = -1;
                if (balance[index] < 0) {
                    balance[index] += amount;
                    balance[i] -= amount;
                    nextResult = search(balance, index, i + 1, maxIndex);
                    balance[index] -= amount;
                    balance[i] += amount;
                } else {
                    balance[index] -= amount;
                    balance[i] += amount;
                    nextResult = search(balance, index, i + 1, maxIndex);
                    balance[index] += amount;
                    balance[i] -= amount;
                }
                if (nextResult == Integer.MAX_VALUE)
                    break;
                result = Math.min(result, nextResult + 1);
            }
        }
        return result;
    }

    public int minTransfers(int[][] transactions) {
        if (transactions.length <= 1)
            return transactions.length;
        int[] balance = new int[20];
        int maxIndex = 0;
        for (int[] transaction : transactions) {
            balance[transaction[0]] += transaction[2];
            maxIndex = Math.max(maxIndex, transaction[0]);
            balance[transaction[1]] -= transaction[2];
            maxIndex = Math.max(maxIndex, transaction[1]);
        }
        return search(balance, 0, 1, maxIndex);
    }
}