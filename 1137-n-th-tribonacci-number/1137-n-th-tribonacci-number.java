class Solution {

    public int tribonacciMem(int n, int[] cache) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        
        if(cache[n] != 0) {
            return cache[n];
        }

        return cache[n] =  tribonacciMem(n - 1, cache) + tribonacciMem(n - 2, cache) + tribonacciMem(n - 3, cache);
    }

    public int tribonacci(int n) {
        return tribonacciMem(n, new int[n + 1]);
    }
}
