package P338;

class Solution {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        if (n == 0)
            return result;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            int half = (i >> 1);
            result[i] = result[half] + (i % 2);
        }
        return result;
    }
}