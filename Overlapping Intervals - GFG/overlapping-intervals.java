// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static class Compare implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if(b[0] < a[0]) {
                return 1;
            } else if(a[0] < b[0]) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    
    public int[][] overlappedInterval(int[][] intervals) {
        Arrays.sort(intervals, new Compare());
    
        Stack<int[]> stk = new Stack<>();
    
        for (int[] interval : intervals) {
          if (stk.empty()) {
            stk.push(interval);
          } else {
            int[] prev = stk.peek();
            // we can merge prev and interval if prev.end >= interval.start
            if (interval[0] <= prev[1]) {
              int newEnd = Math.max(prev[1], interval[1]);
              prev[1] = newEnd;
            } else {
              stk.push(interval);
            }
          }
        }
    
        Stack<int[]> newStack = new Stack<>();
        while (stk.empty() == false) {
          newStack.push(stk.pop());
        }
    
        int n = newStack.size();
        int[][] res = new int[n][2];
    
        int i = 0;
        while (!newStack.empty()) {
          res[i++] = newStack.pop();
        }
    
        return res;
    }
}