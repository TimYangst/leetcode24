package P79WordSearch;

class Solution {
    private static int[] delta = new int[] { 0, 1, 0, -1, 0 };

    private boolean isValid(int x, int y, char[][] board, boolean[][] visited) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length && !visited[x][y];
    }

    private boolean find(char[][] board, int x, int y, String word, int index, boolean[][] visited) {
        if (index >= word.length())
            return true;
        char c = word.charAt(index);
        for (int i = 0; i < 4; i++) {
            int nx = x + delta[i];
            int ny = y + delta[i + 1];
            if (isValid(nx, ny, board, visited) && board[nx][ny] == c) {
                visited[nx][ny] = true;
                if (find(board, nx, ny, word, index + 1, visited))
                    return true;
                visited[nx][ny] = false;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        if (board.length == 0 || board[0].length == 0)
            return false;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    count++;
                else if (board[i][j] == word.charAt(word.length() - 1))
                    count--;
            }
        }
        if (count > 0)
            word = new StringBuilder(word).reverse().toString();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (find(board, i, j, word, 1, visited))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
}