class Solution {
    public int rob(int[] nums) {
        // // method 1, DP, time = O(N), space = O(N)
        // int n = nums.length;
        // int[] dp = new int[n];
        // // init first, second
        // dp[0] = nums[0];
        // if (n > 1) dp[1] = Math.max(nums[0], nums[1]);
        // // current max robbed money = max(current house money + previous last max robbed, last max robbed)
        // for (int i = 2; i < n; i++) dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        // return dp[n - 1];

        // // 2022-07-21
        // // method 2, DP, time = O(N), space = O(N)
        // int n = nums.length;
        // int[] dp = new int[n + 1];
        // dp[1] = nums[0];
        // for (int i = 2; i <= n; i++) dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        // return dp[n];

        // method 3, DP, time = O(N), space = O(1)
        int n = nums.length;
        int cur = 0, prev = 0, prevOfPrev = 0;
        for (int i = 0; i < n; i++) {
            cur = Math.max(nums[i] + prevOfPrev, prev);
            prevOfPrev = prev;
            prev = cur;
        }
        return cur;
        // // short version
        // int n = nums.length, cur = 0, prev = 0, prevOfPrev = 0;
        // for (int i = 0; i < n; i++, prevOfPrev = prev, prev = cur) cur = Math.max(nums[i] + prevOfPrev, prev);
        // return cur;
    }
}