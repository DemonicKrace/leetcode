class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        boolean[][] dp = new boolean[s.length()][s.length()];
        dfs(res, new ArrayList(), s, 0, dp);
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> curList, String s, int start, boolean[][] dp) {
        if (start == s.length()) res.add(new ArrayList(curList));
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                // backtrack, put in
                curList.add(s.substring(start, end + 1));
                dfs(res, curList, s, end + 1, dp);
                // backtrack, pull out 
                curList.remove(curList.size() - 1);
            }
            
            // if (isPlaindrome(s, start, end, dp)) {
            //     // dp[start][end] = true;
            //     // backtrack, put in
            //     curList.add(s.substring(start, end + 1));
            //     dfs(res, curList, s, end + 1, dp);
            //     // backtrack, pull out 
            //     curList.remove(curList.size() - 1);
            // }            
        }
    }
    
    // private boolean isPlaindrome(String s, int left, int right, Boolean[][] dp) {
    //     if (dp[left][right] != null) return dp[left][right];
    //     int l = left, r = right;
    //     while (left < right) 
    //         if (s.charAt(left++) != s.charAt(right--)) {
    //             dp[l][r] = false;
    //             return false;
    //         }
    //     dp[l][r] = true;
    //     return true;
    // }
    
}