package P36VaildSudoku;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length < 9)
            return false;
        for (int i = 0; i < 9; i++)
            if (board[i].length < 9)
                return false;

        for (int i = 0; i < 9; i++) {
            int x = i / 3;
            int y = i % 3;
            if (!(checkRange(board, i, i, 0, 8)
                    && checkRange(board, 0, 8, i, i)
                    && checkRange(board, x * 3, x * 3 + 2, y * 3, y * 3 + 2)))
                return false;
        }
        return true;
    }

    boolean checkRange(char[][] board, int x1, int x2, int y1, int y2) {
        int check = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '0';
                    if ((check & (1 << value)) > 0)
                        return false;
                    check |= (1 << value);
                }
            }
        }
        return true;
    }
}