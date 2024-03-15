package P62UniquePaths;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        return calcC(m + n - 2, m - 1);
    }

    int calcC(int n, int k) {
        if (n - k < k) {
            k = n - k;
        }
        int result = 1;
        for (int i = 1; i <= k; i++) {
            if (result % i == 0) {
                result = (result / i) * (n - k + i);
            } else if ((n - k + i) % i == 0) {
                result = result * ((n - k + i) / i);
            } else {
                int gcd = gcd(result, i);
                result = (result / gcd) * ((n - k + i) / (i / gcd));
            }
        }
        return result;
    }

    int gcd(int a, int b) {
        if (a < b)
            return gcd(b, a);
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }
}