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

// 2022-07-26
class Solution {
    public boolean increasingTriplet(int[] nums) {
        // method 1, iterate to find minimum and second minimum and current greater than both, time = O(N), space = O(1)
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n < first) first = n;
            if (n > first && n < second) second = n;
            if (first < second && second < n) return true;
        }
        return false;
    }
}