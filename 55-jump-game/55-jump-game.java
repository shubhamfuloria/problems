class Solution {
    
    public boolean jump(int[] nums, int n, int pos, Boolean[] store) {
        
        if(pos == n - 1) {
            return true;
        } else if(n <= pos) {
            return false;
        } else if(store[pos] != null) {
            return store[pos];
        }
        
        for(int i = 1; i <= nums[pos]; i++) {
            boolean isPossible = jump(nums, n, pos + i, store);
            if(isPossible == true) {
                return store[pos] = true;
            }
        }
        return store[pos] = false;
    }
    
    public boolean canJump(int[] nums) {
        int  n = nums.length;
        return jump(nums, n, 0, new Boolean[n + 1]);
    }
}