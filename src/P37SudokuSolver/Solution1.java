package P37SudokuSolver;

class Solution1 {

    public void solveSudoku(char[][] board) {
        int[][] check = new int[3][9];
        int remains = 81;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++)
                check[j][i] = 0;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    remains--;
                    fillCheck(i, j, board[i][j], check);
                }
            }
        }
        search(board, check, remains);
    }

    void fillCheck(int x, int y, char c, int[][] check) {
        int value = (1 << (c - '1'));
        check[0][x] += value;
        check[1][y] += value;
        int i = x / 3;
        int j = y / 3;
        check[2][i * 3 + j] += value;
    }

    void removeCheck(int x, int y, char c, int[][] check) {
        int value = (1 << (c - '1'));
        check[0][x] -= value;
        check[1][y] -= value;
        int i = x / 3;
        int j = y / 3;
        check[2][i * 3 + j] -= value;
    }

    boolean search(char[][] board, int[][] check, int remains) {
        if (remains == 0)
            return true;
        int[] next = findFitLocation(board, check);
        if (next == null)
            return false;
        for (char i = '1'; i <= '9'; i++) {
            if (isFit(next[0], next[1], i, check)) {
                board[next[0]][next[1]] = i;
                fillCheck(next[0], next[1], i, check);
                remains--;
                if (search(board, check, remains))
                    return true;
                remains++;
                removeCheck(next[0], next[1], i, check);
                board[next[0]][next[1]] = '.';
            }
        }
        return false;
    }

    int[] findFitLocation(char[][] board, int[][] check) {
        int[] result = new int[2];
        int k = 0;
        int l = 0;
        int minZero = 10;
        for (int i = 0; i < 3; i++) {
            if (minZero == 1)
                break;
            for (int j = 0; j < 9; j++) {
                if (minZero == 1)
                    break;
                int countZero = getCountZero(check[i][j]);
                if (countZero != 0 && countZero < minZero) {
                    minZero = countZero;
                    k = i;
                    l = j;
                }
            }
        }
        if (k == 0) {
            for (int i = 0; i < 9; i++) {
                if (board[l][i] == '.') {
                    result[0] = l;
                    result[1] = i;
                    return result;
                }
            }
        } else if (k == 1) {
            for (int i = 0; i < 9; i++) {
                if (board[i][l] == '.') {
                    result[0] = i;
                    result[1] = l;
                    return result;
                }
            }
        } else {
            int x = l / 3;
            int y = l % 3;
            for (int i = 0; i < 9; i++) {
                if (board[x * 3 + i / 3][y * 3 + i % 3] == '.') {
                    result[0] = x * 3 + i / 3;
                    result[1] = y * 3 + i % 3;
                    return result;
                }
            }
        }
        return null;
    }

    boolean isFit(int x, int y, char c, int[][] check) {
        int value = (1 << (c - '1'));
        int i = x / 3;
        int j = y / 3;
        return ((check[0][x] | check[1][y] | check[2][i * 3 + j]) & value) == 0;
    }

    int getCountZero(int checkValue) {
        int x = checkValue;
        int count = 9;
        while (x != 0) {
            count--;
            x = x & (x - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        char[][] board = new char[][] {
                { '.', '.', '.', '.', '.', '.', '.', '2', '6' },
                { '.', '3', '.', '.', '4', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '5', '.', '9' },
                { '.', '.', '1', '.', '.', '.', '7', '.', '.' },
                { '.', '.', '.', '2', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '9', '.', '.', '.' },
                { '2', '6', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '8', '.', '1', '.', '.' },
                { '9', '.', '.', '.', '.', '.', '.', '4', '.' } };
        solution.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}