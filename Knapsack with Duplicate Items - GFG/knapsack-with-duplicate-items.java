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
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static int knapSackMem(int N, int W, int[] val, int[] wt, int[][] store) {
    
        if(N == 0 || W == 0) {
            return 0;
        } else if(store[N][W] != 0) {
            return store[N][W];
        }
        
        if(wt[N - 1] <= W) {
            
            int op1 = val[N - 1] + knapSackMem(N, W - wt[N - 1], val, wt, store);
            int op2 = knapSackMem(N - 1, W, val, wt, store);
            
            return store[N][W] = Math.max(op1, op2);
            
        } else {
            
            return store[N][W] = knapSackMem(N - 1, W, val, wt, store);
        }
    }
    
    static int knapSack(int N, int W, int val[], int wt[]) {
        
        return knapSackMem(N, W, val, wt, new int[N + 1][W + 1]);
        
    }
}