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