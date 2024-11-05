package P378;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 1)
            return matrix[0][k - 1];
        if (matrix[0].length == 1)
            return matrix[k - 1][0];
        int w = matrix.length;
        int h = matrix[0].length;
        int b = matrix[0][0];
        int e = matrix[w - 1][h - 1];
        int ans = -1;
        while (b <= e) {
            int mid = (b + e) / 2;
            int count = countLessOrEqual(mid, matrix);
            if (count >= k) {
                ans = mid;
                e = mid - 1;
            } else {
                b = mid + 1;
            }
        }
        return ans;
    }

    int countLessOrEqual(int v, int[][] matrix) {
        int result = 0;
        int j = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            while (j >= 0 && matrix[i][j] > v)
                j--;
            if (j >= 0)
                result += j + 1;
            else
                break;
        }
        return result;
    }
}