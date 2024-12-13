package P125ValidPalindrome;

class Solution {
    public boolean isPalindrome(String s) {
        int total = 0;
        int i = 0;
        int l = s.length();
        char[] normalized = new char[l];
        while (i < l) {

            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                normalized[total++] = (char) ('a' + (s.charAt(i) - 'A'));
            } else if (('a' <= s.charAt(i) && s.charAt(i) <= 'z') || ('0' <= s.charAt(i) && s.charAt(i) <= '9')) {
                normalized[total++] = s.charAt(i);
            }
            i++;
        }
        if (total <= 1)
            return true;
        for (int j = 0; j < total / 2; j++) {
            if (normalized[j] != normalized[total - j - 1]) {
                return false;
            }
        }
        return true;
    }
}