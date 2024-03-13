package P51NQueens;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        boolean[][] check = new boolean[4][2 * n];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2 * n; j++) {
                check[i][j] = false;
            }
        }
        List<List<String>> result = new ArrayList<>();
        if (n == 0 || n == 2 || n == 3)
            return result;
        if (n == 1) {
            result.add(List.of("Q"));
            return result;
        }
        for (int i = 0; i < (n + 1) / 2; i++) {
            place(board, check, 0, i, n);
            search(board, check, 1, n, result);
            remove(board, check, 0, i, n);
        }
        return result;
    }

    void search(char[][] board, boolean[][] check, int level, int n, List<List<String>> result) {
        for (int i = 0; i < n; i++) {
            if (canPlace(check, level, i, n)) {
                place(board, check, level, i, n);
                if (level == n - 1) {
                    record(board, result, n);
                } else {
                    search(board, check, level + 1, n, result);
                }
                remove(board, check, level, i, n);
                if (level == n - 1) {
                    return;
                }
            }
        }
    }

    boolean canPlace(boolean[][] check, int x, int y, int n) {
        return !(check[0][x] || check[1][y] || check[2][x + y] || check[3][x - y + n - 1]);
    }

    void place(char[][] board, boolean[][] check, int x, int y, int n) {
        check[0][x] = true;
        check[1][y] = true;
        check[2][x + y] = true;
        check[3][x - y + n - 1] = true;
        board[x][y] = 'Q';
    }

    void remove(char[][] board, boolean[][] check, int x, int y, int n) {
        check[0][x] = false;
        check[1][y] = false;
        check[2][x + y] = false;
        check[3][x - y + n - 1] = false;
        board[x][y] = '.';
    }

    void record(char[][] board, List<List<String>> result, int n) {
        List<String> current = new ArrayList<String>();
        List<String> mirror = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb1.append(board[i][j]);
                sb2.append(board[i][n - 1 - j]);
            }
            current.add(sb1.toString());
            mirror.add(sb2.toString());
        }
        result.add(current);
        if (n % 2 != 1 || board[0][n / 2] != 'Q') {
            result.add(mirror);
        }
    }
}