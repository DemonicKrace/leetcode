class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // // method 1, brute force, time = O(2^N), space = O(N)
        // return wordBreakRecur(s, new HashSet<>(wordDict));        
        // return wordBreakRecur(s, new HashSet<>(wordDict), 0);

        // // method 2, memorization, time = O(N^3), space = O(N)
        // return wordBreakRecurMem(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
        
        // // method 3, BFS, time = O(N^3), space = O(N)
        // int n = s.length();
        // Set<String> set = new HashSet(wordDict);
        // boolean[] visited = new boolean[n];
        // Queue<Integer> que = new ArrayDeque();
        // que.add(0);
        // while (!que.isEmpty()) {
        //     int start = que.poll();
        //     // check computed
        //     if (visited[start]) continue;
        //     for (int end = start + 1; end <= n; end++) {
        //         if (wordDict.contains(s.substring(start, end))) {
        //             // match the last word
        //             if (end == n) return true;
        //             que.add(end);
        //         }
        //     }
        //     // mark start index as computed
        //     visited[start] = true;
        // }
        // return false;
        
        // // N = length of string, M = size of dictionary
        // // method 4, DP, time = O(N^3), space = O(N)
        // int n = s.length();
        // Set<String> wordSet = new HashSet(wordDict);
        // boolean[] dp = new boolean[n + 1];
        // // init first character previous one
        // dp[0] = true;
        // for (int start = 0; start < n; start++)
        //     for (int end = start + 1; end <= n; end++)
        //         // previous part and current part both found 
        //         if (dp[start] && wordSet.contains(s.substring(start, end)))
        //             dp[end] = true;
        // return dp[n];
        
        // N = length of string, M = size of dictionary
        // method 5, DP, time = O(N^2*M), space = O(N)
        int n = s.length();
        Set<String> wordSet = new HashSet(wordDict);
        boolean[] dp = new boolean[n + 1];
        // init first character previous one
        dp[0] = true;
        for (int end = 1; end <= n; end++) {
            // iterate every word in set
            for (String word : wordSet) {
                int len = word.length();
                int lastEnd = end - len;
                // 1. current target word length not greater than end 
                // 2. previous part word was found
                // 3. current target word can fit remaining part
                if (len <= end && dp[lastEnd] && s.substring(lastEnd, end).equals(word)) 
                    dp[end] = true;
            }
        }
        return dp[n];
    }
    
//     private boolean wordBreakRecurMem(String s, Set<String> wordDict, int start, Boolean[] mem) {
//         int n = s.length();
//         if (start == n) return true;
//         if (mem[start] != null) return mem[start];
//         for (int end = start + 1; end <= n; end++) {
//             if (wordDict.contains(s.substring(start, end)) && wordBreakRecurMem(s, wordDict, end, mem)) 
//                 return mem[start] = true;
//         }
//         return mem[start] = false;
//     }
    
//     private boolean wordBreakRecur(String s, Set<String> wordDict) {
//         if (s.length() == 0) return true;
//         int n = s.length();        
//         for (int i = 1; i <= n; i++) {
//             if (wordDict.contains(s.substring(0, i)) && wordBreakRecur(s.substring(i, n), wordDict)) {
//                 return true;
//             }
//         }
//         return false;
//     }
    
//     private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
//         if (start == s.length()) return true;
//         for (int end = start + 1; end <= s.length(); end++) {
//             if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
//                 return true;
//             }
//         }
//         return false;
//     }
}