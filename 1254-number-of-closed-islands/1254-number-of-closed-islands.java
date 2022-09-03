class Solution {

    public boolean isClosedIsland(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) {
            return false;
        } else if (grid[row][col] == 1 || grid[row][col] == -1) {
            return true;
        }

        grid[row][col] = -1; // mark visited

        int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        boolean isClosed = true;
        for (int[] dir : dirs) {
            isClosed = isClosedIsland(grid, row + dir[0], col + dir[1]) && isClosed;
        }
        return isClosed;
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0) {
                    count += isClosedIsland(grid, i, j) ? 1 : 0;
                }
            }
        }

        return count;
    }
}
