package P52NQueensII;

class Solution {
    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 3) {
            return 0;
        }
        boolean check[][] = new boolean[4][n + n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            checkAndPlace(check, 0, i, n);
            result += search(check, 1, n);
            remove(check, 0, i, n);
        }
        return result;
    }

    int search(boolean[][] check, int level, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (checkAndPlace(check, level, i, n)) {
                if (level < n - 1) {
                    result += search(check, level + 1, n);
                } else {
                    result = 1;
                }
                remove(check, level, i, n);
                if (level == n - 1) {
                    break;
                }
            }
        }
        return result;
    }

    boolean checkAndPlace(boolean[][] check, int x, int y, int n) {
        if (check[0][x] || check[1][y] || check[2][x + y] || check[3][x - y + n - 1]) {
            return false;
        }
        check[0][x] = true;
        check[1][y] = true;
        check[2][x + y] = true;
        check[3][x - y + n - 1] = true;
        return true;
    }

    void remove(boolean[][] check, int x, int y, int n) {
        check[0][x] = false;
        check[1][y] = false;
        check[2][x + y] = false;
        check[3][x - y + n - 1] = false;
    }
}
