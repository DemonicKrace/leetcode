class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        int[] count = new int[128];
        // add every pair
        for (char c: s.toCharArray()) if (++count[c] % 2 == 0) result += 2;
        // add middle one if there has some remaining single letter
        return result == s.length() ? result : result + 1;
    }
}