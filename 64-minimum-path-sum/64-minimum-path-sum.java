class Solution {
    
    
    public int solve(int[][] grid, int i, int j, Integer[][] dp) {
        
        if(i == grid.length - 1 && j  == grid[0].length - 1) {
            return grid[i][j];
        } else if(i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        } else if(dp[i][j] != null) {
            return dp[i][j];
        }
        
        //moving right
        int op1 = solve(grid, i, j + 1, dp);
        //moving down
        int op2 = solve(grid, i + 1, j, dp);
        
        
        return dp[i][j] = Math.min(op1, op2) + grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        
        return solve(grid, 0, 0, new Integer[grid.length + 1][grid[0].length + 1]);
    }
}