package P37SudokuSolver;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static int FULL = (1 << 9) - 1;
    static Map<Integer, Character> BIT_MAP;
    static {
        BIT_MAP = new HashMap<>();
        int k = 1;
        char i = '1';
        while (i <= '9') {
            BIT_MAP.put(k, i++);
            k <<= 1;
        }
    }

    boolean search(char[][] board, int[][] status, int remains) {
        if (remains == 0)
            return true;
        int op = 10;
        int x = 0, y = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int eC = getEligibleCount(i, j, status);
                    if (eC == 0)
                        return false;
                    if (eC < op) {
                        op = eC;
                        x = i;
                        y = j;
                    }
                }
                if (op == 1)
                    break;
            }
            if (op == 1)
                break;
        }
        int r = ((~status[0][x]) & (~status[1][y]) & (~status[2][getCellIndex(x, y)]) & FULL);
        while (r > 0) {
            int next = lowbit(r);
            assign(x, y, next, board, status);
            if (search(board, status, remains - 1))
                return true;
            reset(x, y, next, board, status);
            r = r - next;
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        int[][] status = new int[3][9];
        int remains = collectStatus(board, status);
        search(board, status, remains);
    }

    int getEligibleCount(int x, int y, int[][] status) {
        int r = ((~status[0][x]) & (~status[1][y]) & (~status[2][getCellIndex(x, y)]) & FULL);
        return Integer.bitCount(r);
    }

    void assign(int x, int y, int next, char[][] board, int[][] status) {
        status[0][x] += next;
        status[1][y] += next;
        status[2][getCellIndex(x, y)] += next;
        board[x][y] = BIT_MAP.get(next);
    }

    void reset(int x, int y, int next, char[][] board, int[][] status) {
        board[x][y] = '.';
        status[0][x] -= next;
        status[1][y] -= next;
        status[2][getCellIndex(x, y)] -= next;
    }

    int getCellIndex(int x, int y) {
        return (x / 3) * 3 + y / 3;
    }

    int collectStatus(char[][] board, int[][] status) {
        int remains = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int c = board[i][j] - '1';
                    status[0][i] += (1 << c);
                    status[1][j] += (1 << c);
                    status[2][(i / 3) * 3 + (j / 3)] += (1 << c);
                } else {
                    remains++;
                }
            }
        }
        return remains;
    }

    int lowbit(int x) {
        return x & (-x);
    }
}
