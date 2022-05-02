class Solution {
        
    public int climb(int[] cost, int n, int pos, Integer[] dp) {
        
        if(n == pos) {
            return 0;
        } else if(n < pos) {
            return Integer.MAX_VALUE;
        } 
        
        if(dp[pos] != null) {
            return dp[pos];
        }
        
        int op1 = climb(cost, n, pos + 1, dp);
        int op2 = climb(cost, n, pos + 2, dp);
        
        return dp[pos] = Math.min(op1, op2) + cost[pos];
    }
    public int minCostClimbingStairs(int[] cost) {
    
        //climb(n, 0) => returns the minimum cost to reach from 0th stair to nth stair
        int n = cost.length;
        return Math.min(climb(cost, n, 0, new Integer[n + 1]), climb(cost, n, 1, new Integer[n + 1]));
        
    }
}