package P32LongestValidParentheses;

class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1)
            return 0;
        int[] f = new int[s.length()];
        int result = 0;
        f[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                f[i] = 0;
            } else {
                int j = i - 1;
                int k = 1;
                while (k >= 1 && j >= 0) {
                    if (f[j] > 0)
                        j = j - f[j];
                    else {
                        if (s.charAt(j) == '(')
                            k--;
                        else
                            k++;
                        j--;
                    }
                }
                if (k == 0) {
                    if (j < 0) {
                        f[i] = i - j;
                    } else
                        f[i] = i - j + f[j];
                }
            }
            if (f[i] > result)
                result = f[i];
        }
        return result;
    }
}
