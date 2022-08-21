class Solution {

    int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0 || visited[row][col] == true) {
            return 0;
        }

        visited[row][col] = true;

        int[] icoord = { -1, 0, 1, 0 };
        int[] jcoord = { 0, 1, 0, -1 };

        int total_area = 0;
        for (int i = 0; i < 4; i++) {
            int x = row + icoord[i];
            int y = col + jcoord[i];
            total_area += dfs(grid, visited, x, y);
        }
        return total_area + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max_area = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] == false && grid[i][j] == 1) {
                    int curr = dfs(grid, visited, i, j);
                    max_area = Math.max(max_area, curr);
                }
            }
        }
        return max_area;
    }
}
