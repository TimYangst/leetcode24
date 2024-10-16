package P74;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int lb = 0;
        int le = matrix.length - 1;
        while (lb < le) {
            int mid = (lb + le) / 2;
            if (matrix[mid + 1][0] <= target) {
                lb = mid + 1;
            } else {
                le = mid;
            }
        }
        int rb = 0;
        int re = matrix[lb].length - 1;
        while (rb < re) {
            int mid = (rb + re) / 2;
            if (matrix[lb][mid + 1] <= target) {
                rb = mid + 1;
            } else {
                re = mid;
            }
        }
        return matrix[lb][rb] == target;
    }
}