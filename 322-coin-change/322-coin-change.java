class Solution {

    public int solve(int[] coins, int n, int amount, int[][] store) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0 || n == 0) {
            return Integer.MAX_VALUE - 1;
        } else if(store[n][amount] != 0) {
            return store[n][amount];
        }

        // def: will return minimum no of coins that are requierd to make up a amount of
        // amount

        // including n - 1 th coin
        int op1 = solve(coins, n, amount - coins[n - 1], store);
        // excludig n - 1th coin
        int op2 = solve(coins, n - 1, amount, store);

        return store[n][amount] = Math.min(op1 + 1, op2);
    }

    public int coinChange(int[] coins, int amount) {
        
        int res = solve(coins, coins.length, amount, new int[coins.length + 1][amount + 1]);
        if(res == Integer.MAX_VALUE - 1) {
            return -1;
        } else {
            return res;
        }
    }
}
