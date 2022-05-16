class Solution {
    public int[] sortedSquares(int[] nums) {
        
        //find the boundary of positive and negative number
        
        int p = nums.length - 1;
        int n = 0;
        
        while(0 <= p &&  0 <= nums[p]) {
            p--;
        }
        p++;
        
        while(n < nums.length && nums[n] < 0) {
            n++;
        }
        n--;
        
        int [] res = new int[nums.length];
        int i = 0;
        //now p is pointing at left boundary of positive numbers
        //n is pointing at right boundary of negative numbers
        
        while(p < nums.length && -1 < n) {
            
            int ps = nums[p] * nums[p];
            int ns = nums[n] * nums[n];
            
            if(ps < ns) {
                res[i++] = ps;
                p++;
            } else {
                res[i++] = ns;
                n--;
            }
        }
        
        while(p < nums.length) {
            int ps = nums[p] * nums[p];
            res[i++] = ps;
            p++;
        }
        
        while(-1 < n) {
            int ns = nums[n] * nums[n];
            res[i++] = ns;
            n--;
        }
        return res;
    }
}