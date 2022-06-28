class Solution {
    public boolean increasingTriplet(int[] nums) {
        // https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79004/Concise-Java-solution-with-comments.
        // method 1, greedy, best way
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n <= first) first = n;
            else if (n <= second) second = n;
            else return true;
        }        
        return false;
    }
}