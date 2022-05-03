// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

 
    static boolean isSubsetSumMem(int[] A, int n, int sum, Boolean[][] store) {
        
        if (sum == 0) {
          return true;
        } else if (n == 0 || sum < 0) {
          return false;
        } else if (store[n][sum] != null) {
          return store[n][sum];
        }
        
        // including n - 1th element
        boolean op1 = isSubsetSumMem(A, n - 1, sum - A[n - 1], store);
        // excluding n - 1th element
        boolean op2 = isSubsetSumMem(A, n - 1, sum, store);
        
        return store[n][sum] = op1 || op2;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        return isSubsetSumMem(arr, N, sum, new Boolean[N + 1][sum + 1]);
    }
}