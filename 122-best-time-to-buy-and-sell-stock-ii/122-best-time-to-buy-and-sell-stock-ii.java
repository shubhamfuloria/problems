class Solution {

    public int maxProfit(int[] stocks) {
        int buying_date = 0;
        int selling_date = 0;

        int profit = 0;

        for (int i = 1; i < stocks.length; i++) {
            if (stocks[i - 1] <= stocks[i]) {
                selling_date++;
            } else {
                profit += stocks[selling_date] - stocks[buying_date];
                selling_date = buying_date = i;
            }
        }
        profit += stocks[selling_date] - stocks[buying_date];

        return profit;
    }
}
