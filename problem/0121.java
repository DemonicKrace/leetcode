class Solution {
    public int maxProfit(int[] prices) {
        // method 1, store minimum price and find max profit, time = O(N), space = O(1)
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }
}