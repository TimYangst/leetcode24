package P48RotateImage;

class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length <= 1)
            return;

        int xhalf = (length + 1) / 2;
        int yhalf = length / 2;
        for (int i = 0; i < xhalf; i++) {
            for (int j = 0; j < yhalf; j++) {
                rotate(matrix, i, j, length);
            }
        }
    }

    void rotate(int[][] matrix, int x, int y, int length) {
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[length - y - 1][x];
        matrix[length - y - 1][x] = matrix[length - x - 1][length - y - 1];
        matrix[length - x - 1][length - y - 1] = matrix[y][length - x - 1];
        matrix[y][length - x - 1] = tmp;
    }
}