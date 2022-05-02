class Solution {

    public int minPathSum(int[][] cost) {
        int m = cost.length;
        int n = cost[0].length;

        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = cost[i][j];
                } else if (i == m - 1) {
                    // we cannot move to down
                    dp[i][j] = dp[i][j + 1] + cost[i][j];
                } else if (j == n - 1) {
                    // we cannot move to right
                    dp[i][j] = dp[i + 1][j] + cost[i][j];
                } else {
                    // we can move either side (right or bottom)
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + cost[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
