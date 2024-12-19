package P62UniquePaths;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        int f[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            f[i][0] = 1;
        for (int j = 0; j < n; j++)
            f[0][j] = 1;
        return get(m - 1, n - 1, f);
    }

    int get(int m, int n, int[][] f) {
        if (f[m][n] != 0)
            return f[m][n];
        f[m][n] = get(m - 1, n, f) + get(m, n - 1, f);
        return f[m][n];
    }
}
