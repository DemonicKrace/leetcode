class Solution {
    public int longestPalindromeSubseq(String s) {
        // // method 1, DP top down with recursive, time = O(N^2), space = O(N^2)
        // return topDownRecur(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
        
        // // method 2, DP bottom up with loop, time = O(N^2), space = O(N^2)
        // int n = s.length();
        // int[][] dp = new int[n][n];
        // // left start on last character
        // for (int left = n - 1; left >= 0; left--) {
        //     // init
        //     dp[left][left] = 1;
        //     // right start on left + 1
        //     for (int right = left + 1; right < n; right++) {
        //         // dp[left][right] means left to right 
        //         dp[left][right] = (s.charAt(left) == s.charAt(right)) ? dp[left + 1][right - 1] + 2 : Math.max(dp[left][right - 1], dp[left + 1][right]);
        //     }
        // }
        // // return last computed, left = 0, right = n - 1
        // return dp[0][n - 1];
        
        // method 3, DP bottom up with loop, use two row to record, time = O(N^2), space = O(N)
        int n = s.length();
        int[] dp = new int[n];
        int[] dpPrev = new int[n];
        for (int left = n - 1; left >= 0; left--) {
            dp[left] = 1;
            for (int right = left + 1; right < n; right++) {
                dp[right] = (s.charAt(left) == s.charAt(right)) ? dpPrev[right - 1] + 2 : Math.max(dp[right - 1], dpPrev[right]);
            }
            // swap dp, dpPrev
            int[] temp = dp;
            dp = dpPrev;
            dpPrev = temp;            
        }
        return dpPrev[n - 1];
    }
    
    // private int topDownRecur(String s, int left, int right, Integer[][] dp) {
    //     if (left > right) return 0;
    //     if (left == right) return 1;
    //     if (dp[left][right] != null) return dp[left][right];
    //     return dp[left][right] = (s.charAt(left) == s.charAt(right)) ? topDownRecur(s, left + 1, right - 1, dp) + 2 : Math.max(topDownRecur(s, left, right - 1, dp), topDownRecur(s, left + 1, right, dp));
    // }
}