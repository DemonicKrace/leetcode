class Solution {
    public int lengthOfLongestSubstring(String s) {
        // // method 1, use set to check repeating characters, time = O(N), space = O(1), characters is finite
        // int maxLength = 0;
        // int n = s.length();
        // Set<Character> subset = new HashSet();
        // for (int left = 0, right = 0; right < n; ) {
        //     if (subset.add(s.charAt(right))) {
        //         int curSize = subset.size();
        //         maxLength = Math.max(maxLength, curSize);
        //         // remaining length is smaller than previous max length
        //         if (curSize + n - right - 1 < maxLength) break; 
        //         right++;
        //     } else subset.remove(s.charAt(left++));
        // }
        // return maxLength;
        
        // offical solution
        // method 2, use array to check repeating characters, time = O(N), space = O(1)
        int maxLength = 0;
        int[] record = new int[128];
        int start = 0, end = 0, n = s.length();
        while (end < n) {
            record[s.charAt(end++)]++;
            while (record[s.charAt(end - 1)] > 1) record[s.charAt(start++)]--;
            maxLength = Math.max(maxLength, end - start);
        }
        return maxLength;
    }
}