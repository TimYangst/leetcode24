package Top150.P289GameofLife;

class Solution {
    public void gameOfLife(int[][] board) {
        int x = board.length;
        int y = board[0].length;
        if (x == 1 && y == 1) {
            board[0][0] = 0;
            return;
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                countAndSet(board, i, j);
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int count = getAndWipeCount(board, i, j);
                if (count < 2)
                    board[i][j] = 0;
                if (count > 3)
                    board[i][j] = 0;
                if (count == 3)
                    board[i][j] = 1;
            }
        }
    }

    boolean inBoard(int[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    void countAndSet(int[][] board, int x, int y) {
        int result = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0) && inBoard(board, x + i, y + j)) {
                    result += (board[x + i][y + j] & 1);
                }
            }
        }
        board[x][y] += (result << 1);
    }

    int getAndWipeCount(int[][] board, int x, int y) {
        int count = (board[x][y] >> 1);
        board[x][y] &= 1;
        return count;
    }
}