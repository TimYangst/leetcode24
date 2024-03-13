package P51NQueens;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0 || n == 2 || n == 3)
            return result;
        if (n == 1) {
            result.add(List.of("Q"));
            return result;
        }

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        boolean[][] check = new boolean[4][2 * n];
        for (int i = 0; i < (n + 1) / 2; i++) {
            checkAndPlace(board, check, 0, i);
            search(board, check, 1, result);
            remove(board, check, 0, i);
        }
        return result;
    }

    void search(char[][] board, boolean[][] check, int level, List<List<String>> result) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (checkAndPlace(board, check, level, i)) {
                if (level == n - 1) {
                    record(board, result);
                } else {
                    search(board, check, level + 1, result);
                }
                remove(board, check, level, i);
                if (level == n - 1) {
                    return;
                }
            }
        }
    }

    boolean checkAndPlace(char[][] board, boolean[][] check, int x, int y) {
        int n = board.length;
        if (check[0][x] || check[1][y] || check[2][x + y] || check[3][x - y + n - 1]) {
            return false;
        }
        check[0][x] = true;
        check[1][y] = true;
        check[2][x + y] = true;
        check[3][x - y + n - 1] = true;
        board[x][y] = 'Q';
        return true;
    }

    void remove(char[][] board, boolean[][] check, int x, int y) {
        int n = board.length;
        check[0][x] = false;
        check[1][y] = false;
        check[2][x + y] = false;
        check[3][x - y + n - 1] = false;
        board[x][y] = '.';
    }

    void record(char[][] board, List<List<String>> result) {
        int n = board.length;
        List<String> current = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            current.add(String.valueOf(board[i]));
        }
        result.add(current);
        if (n % 2 != 1 || board[0][n / 2] != 'Q') {
            List<String> mirror = new ArrayList<String>();
            for (String row : current) {
                mirror.add(new StringBuilder(row).reverse().toString());
            }
            result.add(mirror);
        }
    }

    public static void main(String[] args) {
        Solution solution1 = new Solution();
        solution1.solveNQueens(5);
    }
}