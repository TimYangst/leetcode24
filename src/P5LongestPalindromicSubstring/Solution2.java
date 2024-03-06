package P5LongestPalindromicSubstring;

class Solution2 {
    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1)
            return s;
        int longest = 1;
        int resultIndex = 0;
        boolean[][] check = new boolean[s.length()][s.length()];
        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                if (l <= 3) {
                    check[i][i + l - 1] = (s.charAt(i) == s.charAt(i + l - 1));
                } else {
                    check[i][i + l - 1] = check[i + 1][i + l - 2]
                            && (s.charAt(i) == s.charAt(i + l - 1));
                }
                if (check[i][i + l - 1]) {
                    longest = l;
                    resultIndex = i;
                }
            }
        }
        return s.substring(resultIndex, resultIndex + longest);
    }
}