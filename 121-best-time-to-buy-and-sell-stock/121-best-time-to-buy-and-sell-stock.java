class Solution {

    public int maxProfit(int[] prices) {
        int least_buying_price = Integer.MAX_VALUE;
        int max_profit = 0;
        int profit_if_sold_today = 0;

        for (int price : prices) {
            if (price < least_buying_price) {
                least_buying_price = price;
            }

            profit_if_sold_today = price - least_buying_price;
            max_profit = Math.max(max_profit, profit_if_sold_today);
        }

        return max_profit;
    }
}
