package P1254NumberOfClosedIslands;

class Solution {
    private static int dx[] = {-1, 0, 1, 0};
    private static int dy[] = {0, 1, 0, -1};

    void dfs(int[][] grid, int x, int y) {
        grid[x][y] = 1;
        for (int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && grid.length > nx 
               && 0 <= ny && grid[0].length > ny) {
                if (grid[nx][ny] == 0) {
                    dfs(grid, nx, ny);
                }
            }
        }
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        if (grid.length < 3  || grid[0].length < 3) return 0;
        int lx = grid.length;
        int ly = grid[0].length;
        for (int i = 0; i < lx; i++) {
            if (grid[i][0] == 0) {
                dfs(grid, i, 0);
            }
            if (grid[i][ly - 1] == 0) {
                dfs(grid, i, ly-1);
            }
        }
        for (int j = 0; j < ly; j++) {
            if (grid[0][j] == 0) {
                 dfs(grid, 0, j);
            }
            if (grid[lx-1][j] == 0) {
                dfs(grid, lx-1, j);
            } 
        }
        for (int i = 1; i < lx - 1; i++) {
            for (int j = 1; j < ly - 1; j++) {
                if (grid[i][j] == 0) {
                    count++; 
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}