class Solution {

    void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == '0' || visited[row][col] == true) {
            return;
        }

        visited[row][col] = true;

        int[] icoord = { -1, 0, 1, 0 };
        int[] jcoord = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int x = row + icoord[i];
            int y = col + jcoord[i];
            dfs(grid, visited, x, y);
        }
        // visited[row][col] = false;

    }

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    if (visited[i][j] == false) {
                        dfs(grid, visited, i, j);
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
