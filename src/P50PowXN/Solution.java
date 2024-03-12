package P50PowXN;

class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0)
            return 0;
        if (n == 1)
            return x;
        if (n == -1)
            return 1 / x;
        int half = n / 2;
        double result = myPow(x, half);
        result = result * result;
        if (n % 2 == 1) {
            return result * x;
        } else if (n % 2 == -1) {
            return result / x;
        }
        return result;
    }
}