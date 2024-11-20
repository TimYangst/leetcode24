package P529;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private void getCounter(char[][] board, int[][] counter) {
        int r = board.length;
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'M') {
                    counter[i][j] = -1;
                    for (int dx = -1; dx <= 1; dx++) {
                        if (dx + i < 0 || dx + i >= r)
                            continue;
                        for (int dy = -1; dy <= 1; dy++) {
                            if ((dx == 0 && dy == 0)
                                    || j + dy < 0 || j + dy >= c)
                                continue;
                            counter[i + dx][j + dy]++;
                        }
                    }
                }
            }
        }
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int r = board.length;
        int c = board[0].length;
        int[][] counter = new int[r][c];
        getCounter(board, counter);
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        if (counter[click[0]][click[1]] != 0) {
            board[click[0]][click[1]] = (char) ('0' + counter[click[0]][click[1]]);
            return board;
        }
        board[click[0]][click[1]] = 'B';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = -1; i <= 1; i++) {
                if (current[0] + i < 0 || current[0] + i >= r)
                    continue;
                for (int j = -1; j <= 1; j++) {
                    if ((i == 0 && j == 0)
                            || current[1] + j < 0 || current[1] + j >= c)
                        continue;
                    int nx = current[0] + i;
                    int ny = current[1] + j;
                    if (counter[nx][ny] == 0 && board[nx][ny] != 'B') {
                        board[nx][ny] = 'B';
                        queue.add(new int[] { nx, ny });
                    } else if (counter[nx][ny] > 0) {
                        board[nx][ny] = (char) ('0' + counter[nx][ny]);
                    }
                }
            }
        }
        return board;
    }
}