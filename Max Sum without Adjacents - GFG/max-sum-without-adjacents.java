// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    
    int dfs(int [] A, int pos, int[] store) {
        if (pos == A.length) {
          return 0;
        } else if (pos == A.length - 1) {
          return A[pos];
        } else if (pos == A.length - 2) {
          return Math.max(A[pos], A[pos + 1]);
        } else if(store[pos] != 0) {
            return store[pos];
        }
    
        // including current element
        int op1 = A[pos] + dfs(A, pos + 2, store);
    
        // not including current element
        int op2 = dfs(A, pos + 1, store);
    
        return store[pos] = Math.max(op1, op2);
    }
    int findMaxSum(int[] A, int n) {
        return dfs(A, 0, new int[n + 1]);    
    }
}