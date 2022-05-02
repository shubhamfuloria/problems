class Solution {
    
    public int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        
        if(i < 0 || j < 0 || i == grid.length || j == grid[i].length || visited[i][j] == true || grid[i][j] == 0) {
            return 0;
        }
        
        
        visited[i][j] = true;
        
        //moving top
        int op1 = dfs(grid, visited, i - 1, j);
        //mobing right
        int op2 = dfs(grid, visited, i, j + 1);
        //moving down
        int op3 = dfs(grid, visited, i + 1, j);
        //moving left;
        int op4 = dfs(grid, visited, i, j - 1);
        
        visited[i][j] = false;
        
        return Math.max(op1, Math.max(op2, Math.max(op3, op4))) + grid[i][j];
    }
    public int getMaximumGold(int[][] grid) {
        
        int max_gold = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int curr = dfs(grid, new boolean [m][n], i, j);
                max_gold = Math.max(curr, max_gold);
            }
        }
        
        return max_gold;
        
    }
}