class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // // method 1, T=O(MN) S=O(MN)
        // int n1 = text1.length();
        // int n2 = text2.length();
        // int[][] table = new int[n1 + 1][n2 + 1];
        // for (int i1 = 0; i1 < n1; i1++) {
        //     for (int i2 = 0; i2 < n2; i2++) {
        //         table[i1 + 1][i2 + 1] = (text1.charAt(i1) == text2.charAt(i2)) ? table[i1][i2] + 1 : Math.max(table[i1 + 1][i2], table[i1][i2 + 1]);
        //     }
        // }
        // return table[n1][n2];
        
        // method 2, T=O(MN) S=O(N)
        int n1 = text1.length();
        int n2 = text2.length();
        int[] dp = new int[n2 + 1];
        int[] dpPrev = new int[n2 + 1];
        for (int i1 = 0; i1 < n1; i1++) {
            for (int i2 = 0; i2 < n2; i2++) {
                dp[i2 + 1] = (text1.charAt(i1) == text2.charAt(i2)) ? dpPrev[i2] + 1 : Math.max(dp[i2], dpPrev[i2 + 1]);
            }
            // swap
            int[] temp = dp;
            dp = dpPrev;
            dpPrev = temp;
        }
        return dpPrev[n2];
    }
}