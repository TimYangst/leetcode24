package P73SetMatrixZeroes;

class Solution {
    public void setZeroes(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        boolean zeroX = false, zeroY = false;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0)
                        zeroY = true;
                    if (j == 0)
                        zeroX = true;
                }
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (zeroX) {
            for (int i = 0; i < x; i++) {
                matrix[i][0] = 0;
            }
        }
        if (zeroY) {
            for (int j = 0; j < y; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}