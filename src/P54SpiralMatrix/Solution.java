package P54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0)
            return result;
        int n = matrix.length;
        int m = matrix[0].length;
        visit(matrix, 0, 0, n, m, result);
        return result;
    }

    void visit(int[][] matrix, int x, int y, int lx, int ly, List<Integer> result) {
        if (lx <= 0 || ly <= 0)
            return;
        if (lx == 1 || ly == 1) {
            for (int i = 0; i < lx; i++) {
                for (int j = 0; j < ly; j++) {
                    result.add(matrix[x + i][y + j]);
                }
            }
            return;
        }
        for (int j = 0; j < ly - 1; j++) {
            result.add(matrix[x][y + j]);
        }
        for (int i = 0; i < lx - 1; i++) {
            result.add(matrix[x + i][y + ly - 1]);
        }
        for (int j = ly - 1; j > 0; j--) {
            result.add(matrix[x + lx - 1][y + j]);
        }
        for (int i = lx - 1; i > 0; i--) {
            result.add(matrix[x + i][y]);
        }
        visit(matrix, x + 1, y + 1, lx - 2, ly - 2, result);
    }
}