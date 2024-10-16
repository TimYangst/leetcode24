package P427;

// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

class Solution {
    private int sum(int[][] s, int x0, int y0, int x1, int y1) {
        return s[x1 + 1][y1 + 1] + s[x0][y0] - s[x1 + 1][y0] - s[x0][y1 + 1];
    }

    private boolean isFull(int[][] s, int x0, int y0, int x1, int y1) {
        int sum = sum(s, x0, y0, x1, y1);
        return (sum == 0) || (sum == (x1 - x0 + 1) * (y1 - y0 + 1));
    }

    private Node build(int[][] grid, int x0, int y0, int x1, int y1, int[][] s) {
        if (x0 == x1 || isFull(s, x0, y0, x1, y1)) {
            return new Node(grid[x0][y0] == 1, true);
        }
        int midX = (x0 + x1) / 2;
        int midY = (y0 + y1) / 2;
        return new Node(false, false,
                build(grid, x0, y0, midX, midY, s),
                build(grid, x0, midY + 1, midX, y1, s),
                build(grid, midX + 1, y0, x1, midY, s),
                build(grid, midX + 1, midY + 1, x1, y1, s));
    }

    public Node construct(int[][] grid) {
        if (grid.length == 0)
            return null;
        if (grid.length == 1) {
            return new Node(grid[0][0] == 1, true);
        }
        int[][] s = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                s[i + 1][j + 1] = grid[i][j] + s[i][j + 1] + s[i + 1][j] - s[i][j];
            }
        }
        return build(grid, 0, 0, grid.length - 1, grid[0].length - 1, s);
    }

}