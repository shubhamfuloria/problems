// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int fun(String S) {
        
        int mod = (int)Math.pow(10, 9) + 7;
        
        int a = 0;
        int ab = 0;
        int abc = 0;
    
        for (int i = 0; i < S.length(); i++) {
          char ch = S.charAt(i);
    
          if (ch == 'a') {
            a = (2 * a % mod + 1) % mod;
          } else if (ch == 'b') {
            ab = (2 * ab % mod + a) % mod;
          } else if (ch == 'c') {
            abc = (2 * abc % mod + ab) % mod;
          }
        }
        return abc % mod;
    }
}