class Solution {
    
    public int solve(int[] nums, int target, int n) {
        
        if(target == 0 && n == 0) {
            return 1;
        } else if(n == 0) {
            return 0;
        }
        
        //treating n - 1th element as positive 
        int op1 = solve(nums, target + nums[n - 1], n - 1);
        
        //traeting n - 1th element as negative
        int op2 = solve(nums, target - nums[n - 1], n- 1);
        
        
        return op1 + op2;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, nums.length);
    }
}