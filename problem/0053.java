class Solution {

    public int maxSubArray(int[] nums) {
        // // method 1, DP store max sum of range to current cell, time = O(N), space = O(N)
        // int maxSum = nums[0];
        // int n = nums.length;
        // int[] dp = new int[n + 1];
        // for (int i = 0; i < n; i++) {
        //     dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
        //     maxSum = Math.max(maxSum, dp[i + 1]);
        // }
        // return maxSum;

        // // method 2, DP store max sum of range to current cell, time = O(N), space = O(1)
        // int maxSum = nums[0], n = nums.length;
        // int prev = 0, cur = 0;
        // for (int i = 0; i < n; i++) {
        //     cur = Math.max(prev + nums[i], nums[i]);
        //     maxSum = Math.max(maxSum, cur);
        //     prev = cur;
        // }
        // return maxSum;
        
        // method 3, divide and conquer, time = O(N), space = O(1)
        int n = nums.length;
        // precomputation, store current cell leftward's max sum
        int[] prefix = Arrays.copyOf(nums, n);
        // precomputation, store current cell rightward's max sum
        int[] suffix = Arrays.copyOf(nums, n);
        // current cell max sum = current cell value + previous max sum (discard previous sum when it smaller than zero)
        for (int i = 1; i < n; i++) prefix[i] += Math.max(0, prefix[i - 1]); 
        for (int i = n - 2; i >= 0; i--) suffix[i] += Math.max(0, suffix[i + 1]); 
        return dcMaxSubArray(nums, 0, n - 1, prefix, suffix);
    }
    
    private int dcMaxSubArray(int[] nums, int low, int high, int[] prefix, int[] suffix) {
        if (low == high) return nums[low];
        int mid = low + (high - low) / 2;
        int maxLeft = dcMaxSubArray(nums, low, mid, prefix, suffix);
        int maxRight = dcMaxSubArray(nums, mid + 1, high, prefix, suffix);
        // max sum range may be 1. in left part 2. in right part 3. between left and right part
        return Math.max(Math.max(maxLeft, maxRight), prefix[mid] + suffix[mid + 1]);
    }
}