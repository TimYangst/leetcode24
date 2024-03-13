package P54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0)
            return result;
        int lx = matrix.length;
        int ly = matrix[0].length;
        int x = 0;
        int y = 0;
        while (lx > 0 && ly > 0) {
            if (lx == 1 || ly == 1) {
                for (int i = 0; i < lx; i++) {
                    for (int j = 0; j < ly; j++) {
                        result.add(matrix[x + i][y + j]);
                    }
                }
                break;
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

            x++;
            y++;
            lx -= 2;
            ly -= 2;
        }
        return result;
    }
}
