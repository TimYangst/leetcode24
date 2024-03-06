package P5LongestPalindromicSubstring;

class Solution1 {
    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1)
            return s;
        for (int k = s.length(); k >= 1; k--) {
            for (int e = k; e <= s.length(); e++) {
                if (isPalindromic(s, e - k, e)) {
                    return s.substring(e - k, e);
                }
            }
        }
        return s.substring(0, 1);
    }

    boolean isPalindromic(String s, int b, int e) {
        int m = (b + e) / 2;

        for (int i = b; i < m; i++) {
            if (s.charAt(i) != s.charAt(e - (i - b) - 1)) {
                return false;
            }
        }
        return true;
    }
}