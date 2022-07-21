class Solution {
    public int climbStairs(int n) {
        // // mehtod 1, DP, time = O(N), space = O(N)
        // if (n < 4) return n;
        // int[] dp = new int[n];
        // for (int i = 0; i < n; i++) {
        //     if (i < 3) dp[i] = i + 1;
        //     else dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n - 1];
        
        // mehtod 2, DP, time = O(N), space = O(1)
        if (n < 4) return n;
        int prevOfPrev = 1, prev = 2, result = 0;
        while (n-- > 2) {
            result = prev + prevOfPrev;
            prevOfPrev = prev;
            prev = result;
        }
        return result;
    }
}