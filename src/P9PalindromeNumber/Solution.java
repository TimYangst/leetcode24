package P9PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int y = x;
        int k = 1;
        while (y >= 10) {
            y = y / 10;
            k = k * 10;
        }
        y = x;
        while (k != 0) {
            if (y / k != y % 10)
                return false;
            y = (y - (y / k) * k) / 10;
            k = k / 100;
        }
        return true;
    }
}