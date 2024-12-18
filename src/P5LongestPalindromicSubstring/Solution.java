package P5LongestPalindromicSubstring;

class Solution {
    int[] expand(String s, int b, int e) {
        int[] result = new int[2];
        while (b >= 0 && e < s.length() && s.charAt(b) == s.charAt(e)) {
            b--;
            e++;
        }
        result[0] = (e - 1 - (b + 1) + 1);
        result[1] = b + 1;
        return result;
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1)
            return s;
        int[] current = new int[] { 1, 0 }; // l = 1, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] next = expand(s, i, i);
            if (next[0] > current[0])
                current = next;
            next = expand(s, i, i + 1);
            if (next[0] > current[0])
                current = next;
        }
        return s.substring(current[1], current[1] + current[0]);
    }
}
