package Top150.P202HappyNumber;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> exists = new HashSet<>();
        while (n != 1) {
            if (exists.contains(n))
                break;
            exists.add(n);
            n = sumOfSquares(n);
        }
        return n == 1;
    }

    int sumOfSquares(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }
}