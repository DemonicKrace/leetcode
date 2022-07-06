class Solution {
    public String longestPalindrome(String s) {
        // // method 1, iterate every character as middle to try to expand, time = O(N^2), space = O(1)
        // int n = s.length();
        // int start = 0;
        // int end = 0;
        // for (int i = 0; i < n; i++) {
        //     int oddLen = computeLength(s, i, i);
        //     int evenLen = computeLength(s, i, i + 1);
        //     int len = Math.max(oddLen, evenLen);
        //     if (len > end - start + 1) {
        //         start = i - (len - 1) / 2;
        //         end = start + len - 1;
        //     }
        // }
        // return s.substring(start, end + 1);
        
        // method 2, dp, time = O(N^2), space = O(N^2)
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;
        for (int right = 0; right < n; right++) {
            dp[right][right] = true;
            for (int left = right - 1; left >= 0; left--) {
                if (s.charAt(right) == s.charAt(left) && (right - left == 1 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                    if (right - left + 1 > maxLen) {
                        start = left;
                        maxLen = right - left + 1;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
    
    // private int computeLength(String s, int left, int right) {
    //     while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    //         left--;
    //         right++;
    //     }
    //     return right - left - 1;
    // }
}