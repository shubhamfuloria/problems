class Solution {

    public int climbStairsMem(int n, int[] cache) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if(cache[n] != 0) {
            return cache[n];
        }
        

        return cache[n] = climbStairsMem(n - 1, cache) + climbStairsMem(n - 2, cache);
    }

    public int climbStairs(int n) {
        return climbStairsMem(n, new int[n + 1]);
    }
}
