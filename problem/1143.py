class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        # method 1, dp Space = O(N)
        m, n = len(text1), len(text2)
        dp, dpPrev = [0] * (n+1), [0] * (n+1)
        for i in range(0, m):
            for j in range(0, n):
                dp[j + 1] = dpPrev[j] + 1 if text1[i] == text2[j] else max(dp[j], dpPrev[j + 1])
            dp, dpPrev = dpPrev, dp
        return dpPrev[n]
