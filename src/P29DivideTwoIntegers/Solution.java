package P29DivideTwoIntegers;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (divisor == 1)
            return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == divisor)
                return 1;
            return 0;
        }
        boolean neg = false;
        int result = 0;

        if (dividend == Integer.MIN_VALUE) {
            result++;
            if (divisor < 0)
                dividend -= divisor;
            else
                dividend += divisor;
        }

        if (dividend < 0) {
            dividend = -dividend;
            neg = !neg;
        }
        if (divisor < 0) {
            divisor = -divisor;
            neg = !neg;
        }
        int factor = 1;
        int current = divisor;
        while (dividend >> 1 >= current) {
            factor = factor << 1;
            current = current << 1;
        }

        while (dividend >= divisor) {
            dividend -= current;
            result += factor;
            while (current > dividend) {
                current = current >> 1;
                factor = factor >> 1;
            }
        }
        if (neg)
            return -result;
        return result;
    }
}