class Solution {
    Integer[] dp;

    public int getMaximumGenerated(int n) {
        // // method 1, dp
        // if (n <= 1) return n;
        // int[] arr = new int[n + 1];
        // arr[0] = 0;
        // arr[1] = 1;
        // int maxValue = 0;
        // for (int i = 2; i <= n; i++) {
        //     arr[i] = (i % 2 == 0 ? arr[i / 2] : arr[i / 2] + arr[i / 2 + 1]);
        //     maxValue = Math.max(maxValue, arr[i]);
        // }
        // return maxValue;
        
        // // method 2, dp
        // if (n <= 1) return n;
        // dp = new Integer[n + 1];
        // int maxValue = 0;
        // for (int i = 2; i <= n; i++) {
        //     maxValue = Math.max(maxValue, getValue(i));
        // }
        // return maxValue;
    }
    
    int getValue(int n) {
        if (n <= 1) {
            dp[n] = n;
            return dp[n];
        }
        if (dp[n] != null) return dp[n];        
        dp[n] = (n % 2 == 0 ? getValue(n / 2) : getValue(n / 2) + getValue(n / 2 + 1));
        return dp[n];
    }    
}