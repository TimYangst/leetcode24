package P528;

import java.util.Random;

class Solution {
    int[] s;
    Random random;

    public Solution(int[] w) {
        s = new int[w.length];
        s[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            s[i] = s[i - 1] + w[i];
        }
        random = new Random();
    }

    public int pickIndex() {
        int randomInt = random.nextInt(s[s.length - 1]);
        int b = 0;
        int e = s.length - 1;
        while (b < e) {
            int mid = (b + e) / 2;
            if (s[mid] == randomInt)
                return mid + 1;
            if (s[mid] < randomInt)
                b = mid + 1;
            else
                e = mid;
        }
        return b;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */