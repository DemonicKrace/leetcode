class Solution {
    public int majorityElement(int[] nums) {
        // https://leetcode.com/problems/majority-element/solution/
        
        // best way, Boyer-Moore Voting Algorithm
        int candidate = -1;
        int count = 0;
        for (int n: nums) {
            if (count == 0) candidate = n;
            count += (candidate == n) ? 1 : -1;
        }
        return candidate;        
    }
}