package Contest.P3;

import java.util.Arrays;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] count = new int[26];
        if (word.length() <= 1)
            return 0;
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
        Arrays.sort(count);
        int i = 25;
        while (i > 0 && count[i - 1] > 0)
            i--;
        if (i == 25)
            return 0;
        int minResult = getResult(count, i, count[i], k);

        for (int j = i + 1; j <= 25; j++) {
            int tmp = getResult(count, i, count[j], k);
            if (tmp < minResult)
                minResult = tmp;
        }
        return minResult;
    }

    int getResult(int[] count, int i, int l, int k) {
        int result = 0;
        for (int index = i; index <= 25; index++) {
            if (count[index] < l)
                result += count[index];
            else if (count[index] > l + k)
                result += count[index] - l - k;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeletions("dabdcbdcdcd", 2));
    }
}