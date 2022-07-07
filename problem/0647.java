class Solution {
    public int countSubstrings(String s) {
        // method 1, time = O(N^2), space = O(1)
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            // odd count
            count += computeCount(s, i, i);
            // even count
            count += computeCount(s, i, i + 1);
        }
        return count;
        
        // // method 2, DP bottom up with loop, use two row to record, time = O(N^2), space = O(N)
        // int count = 0;
        // int n = s.length();
        // boolean[] dp = new boolean[n];
        // boolean[] dpPrev = new boolean[n];
        // for (int left = n - 1; left >= 0; left--) {
        //     for (int right = left; right < n; right++) {
        //         dp[right] = (s.charAt(left) == s.charAt(right)) && (right - left < 3 || dpPrev[right - 1]);
        //         if (dp[right]) count++;
        //     }
        //     // swap dp, dpPrev
        //     boolean[] temp = dp;
        //     dp = dpPrev;
        //     dpPrev = temp;            
        // }
        // return count;
    }
    
    private int computeCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}