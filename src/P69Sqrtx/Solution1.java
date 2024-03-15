package P69Sqrtx;

class Solution1 {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        return binarySearch(1, Math.min((int) x / 2, (int) ((1 << 15) * 1.5)), x);
    }

    int binarySearch(int b, int e, int x) {
        if (b == e)
            return b;
        int m = (b + e) / 2;
        if (m <= (x / m) && (m + 1 > (x / (m + 1))))
            return m;
        if (m < (x / m))
            return binarySearch(m + 1, e, x);
        return binarySearch(b, m, x);
    }
}