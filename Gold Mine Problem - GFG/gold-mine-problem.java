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
    public static int dig(int[][] mine, int i, int j, int[][] dp) {
        
        if (i < 0 || j < 0 || i == mine.length || j == mine[i].length) {
          return 0;
        } else if(dp[i][j] != 0) {
            return dp[i][j];
        }
        
        // digging top right diagonal
        int op1 = dig(mine, i - 1, j + 1, dp);
        // digging straight right
        int op2 = dig(mine, i, j + 1, dp);
        // digging down right diagonal
        int op3 = dig(mine, i + 1, j + 1, dp);
        
        return dp[i][j] = Math.max(op1, Math.max(op2, op3)) + mine[i][j];
    }
    static int maxGold(int n, int m, int M[][]) {
        // code her
        int max_gold = 0;
        int[][] dp = new int[n][m];
        for(int i = 0; i < M.length; i++) {
            int curr = dig(M, i, 0, dp);
            max_gold = Math.max(max_gold, curr);
        }
        
        return max_gold;
    }
}