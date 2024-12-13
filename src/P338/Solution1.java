package P338;

class Solution1 {

    int lowbit(int x) {
        return x & -x;
    }

    int count(int v) {
        int res = 0;
        while (v != 0) {
            v -= lowbit(v);
            res++;
        }
        return res;
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++)
            result[i] = count(i);
        return result;
    }
}
