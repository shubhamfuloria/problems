class Solution {
    public int climbStairs(int n) {
        
        if(n == 1) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        //each cell of dp will contain minimum number of ways to climb i staircases
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i < n + 1; i++) {    
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}