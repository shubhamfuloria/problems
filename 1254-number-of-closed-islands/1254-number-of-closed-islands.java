class Solution {

    public boolean isClosedIsland(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) {
            return false;
        } else if (grid[row][col] == 1 || grid[row][col] == 2) {
            return true;
        }

        grid[row][col] = 2;

        boolean top = isClosedIsland(grid, row - 1, col);
        boolean right = isClosedIsland(grid, row, col + 1);
        boolean bottom = isClosedIsland(grid, row + 1, col);
        boolean left = isClosedIsland(grid, row, col - 1);

        return top && right && bottom && left;
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0 && isClosedIsland(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
