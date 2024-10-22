package P680;

class Solution {
    boolean isPalindrome(String s, int b, int e) {
        int i = b;
        int j = e;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }

    public boolean validPalindrome(String s) {
        if (s.length() <= 2)
            return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        if (i < j) {
            return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return true;
    }
}