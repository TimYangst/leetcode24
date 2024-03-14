package P59SpiralMatrixII;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        fill(result, 0, n, 1);
        return result;
    }

    void fill(int[][] result, int level, int length, int k) {
        if (length == 0)
            return;
        if (length == 1) {
            result[level][level] = k;
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            result[level][level + i] = k++;
        }
        for (int i = 0; i < length - 1; i++) {
            result[level + i][level + length - 1] = k++;
        }
        for (int i = 0; i < length - 1; i++) {
            result[level + length - 1][level + length - 1 - i] = k++;
        }
        for (int i = 0; i < length - 1; i++) {
            result[level + length - 1 - i][level] = k++;
        }
        fill(result, level + 1, length - 2, k);
    }
}
