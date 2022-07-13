class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) 
            // add earned profit if positive
            profit += Math.max(0, prices[i] - prices[i - 1]);
        return profit;
    }
}