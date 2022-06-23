class Solution {
    public int longestSubstring(String s, int k) {
        // reference by offical soultion

        // // method 1, brute force
        // int result = 0;
        // int[] countMap = new int[26];
        // int n = s.length();
        // for (int start = 0; start < n; start++) {
        //     Arrays.fill(countMap, 0);
        //     for (int end = start; end < n; end++) {
        //         countMap[s.charAt(end) - 'a']++;
        //         int letterCount = 0;
        //         int letterLeastKCount = 0;
        //         for (int count: countMap) {
        //             if (count == 0) continue;
        //             if (count > 0) letterCount++;
        //             if (count >= k) letterLeastKCount++;
        //         }
        //         if (letterCount == letterLeastKCount)
        //             result = Math.max(result, end - start + 1);
        //     }
        // }
        // return result;
        
        // // method 2, divide and conquer
        // return longestSubstr(s, 0, s.length(), k);
        
        // method 3, sliding window
        int result = 0;
        int maxUniqueLetterCount = computeUniqueCount(s);
        int[] countMap = new int[26];
        int n = s.length();
        for (int uniqueLetter = 1; uniqueLetter <= maxUniqueLetterCount; uniqueLetter++) {
            // reset map
            Arrays.fill(countMap, 0);
            int wStart = 0;
            int wEnd = 0;
            int curUnique = 0;
            int curUniqueLeastK = 0;
            int index = 0;
            while (wEnd < n) {
                // expand window
                if (curUnique <= uniqueLetter) {
                    index = s.charAt(wEnd) - 'a';
                    if (countMap[index] == 0) curUnique++;
                    countMap[index]++;
                    if (countMap[index] == k) curUniqueLeastK++;
                    wEnd++;
                // shrink window
                } else {
                    index = s.charAt(wStart) - 'a';
                    if (countMap[index] == k) curUniqueLeastK--;
                    countMap[index]--;
                    if (countMap[index] == 0) curUnique--;
                    wStart++;
                }
                // store max length
                if (curUnique == uniqueLetter && curUniqueLeastK == uniqueLetter) {
                    result = Math.max(result, wEnd - wStart);
                }
            }
        }
        return result;     
    }
    
    // private int longestSubstr(String s, int start, int end, int k) {
    //     if (end - start < k) return 0;
    //     int[] countMap = new int[26];
    //     for (int i = start; i < end; i++) {
    //         countMap[s.charAt(i) - 'a']++;
    //     }        
    //     for (int mid = start; mid < end; mid++) {
    //         if (countMap[s.charAt(mid) - 'a'] < k) {
    //             int next = mid + 1;
    //             while (next < end && countMap[s.charAt(next) - 'a'] < k) next++;
    //             return Math.max(longestSubstr(s, 0, mid, k), longestSubstr(s, next, end, k));
    //         }
    //     }
    //     return end - start;
    // }
    
    private int computeUniqueCount(String s) {
        int count = 0;
        boolean[] table = new boolean[26];
        for (char c: s.toCharArray()) {
            if (!table[c - 'a']) {
                count++;
                table[c - 'a'] = true;
            }
        }
        return count;
    }
}