// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    
    static int solve(int W, int[] wt, int[] val, int n, int[][] store) {
        
        if(n == 0 || W == 0) {
            return 0;
        } else if(store[n][W] != 0) {
            return store[n][W];
        }
        
        // def: will return max value of products we can get from these items in W
        // weight
    
        if (wt[n - 1] <= W) {
          // we can include n - 1th item
          int op1 = val[n - 1] + solve(W - wt[n - 1], wt, val, n - 1, store);
          int op2 = solve(W, wt, val, n - 1, store);
          return store[n][W] = Math.max(op1, op2);
        } else {
          // we can not include n - 1th item
          return store[n][W] = solve(W, wt, val, n - 1, store);
        }
    }
    
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) { 

        return solve(W, wt, val, n, new int[n + 1][W + 1]); 
    }
}

