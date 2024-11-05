package P766;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length <= 1 || matrix[0].length <= 1)
            return true;
        for (int i = 0; i < matrix[0].length; i++) {
            int j = 1;
            int k = i + 1;
            while (j < matrix.length && k < matrix[0].length) {
                if (matrix[0][i] != matrix[j][k])
                    return false;
                j++;
                k++;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            int j = i + 1;
            int k = 1;
            while (j < matrix.length && k < matrix[0].length) {
                if (matrix[i][0] != matrix[j][k])
                    return false;
                j++;
                k++;
            }
        }
        return true;
    }
}