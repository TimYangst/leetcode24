package P329;

class Solution {
    static int[] d = { 0, 1, 0, -1, 0 };

    int search(int x, int y, int[][] matrix, int[][] maxPath) {
        if (maxPath[x][y] > 0)
            return maxPath[x][y];
        maxPath[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i];
            int ny = y + d[i + 1];
            if (0 <= nx && nx < matrix.length && 0 <= ny && ny < matrix[0].length
                    && matrix[x][y] < matrix[nx][ny]) {
                maxPath[x][y] = Math.max(maxPath[x][y], 1 + search(nx, ny, matrix, maxPath));
            }
        }
        return maxPath[x][y];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] maxPath = new int[h][w];
        int result = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (maxPath[i][j] == 0) {
                    maxPath[i][j] = search(i, j, matrix, maxPath);
                }
                if (maxPath[i][j] > result)
                    result = maxPath[i][j];
            }
        }
        return result;
    }
}
