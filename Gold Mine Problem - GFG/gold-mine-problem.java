// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int mine[][]) {
    
        int[][] dp = new int[n][m];
    
        // each cell of dp will contain max gold that can be achieved, if we start
        // digging from that cell
        // if we start digging from the last column , them the problem is smaller
    
        for (int j = m - 1; j >= 0; j--) {
          for (int i = 0; i < n; i++) {
    
            if (j == m - 1) {
              dp[i][j] = mine[i][j];
            } else if(i == 0 && n == 1) {
                dp[i][j] = dp[i][j + 1] + mine[i][j];  
            } else if (i == 0 && n > 1) {
              dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + mine[i][j];
            } else if (i == n - 1) {
              dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + mine[i][j];
            } else {
              dp[i][j] = Math.max(dp[i - 1][j + 1], Math.max(dp[i][j + 1], dp[i + 1][j + 1])) + mine[i][j];
            }
          }
        }
        // we can start from any row of first column
        int max_gold = 0;
    
        for (int i = 0; i < dp.length; i++) {
          max_gold = Math.max(max_gold, dp[i][0]);
        }
    
        return max_gold;
    }
}