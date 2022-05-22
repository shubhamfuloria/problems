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
    int findMaxSum(int A[], int n) {
        int inc = A[0];
        int exc = 0;
    
        for (int i = 1; i < A.length; i++) {
          int ninc = A[i] + exc;
          int nexc = Math.max(inc, exc);
    
          inc = ninc;
          exc = nexc;
        }
    
        return Math.max(inc, exc);
    }
}