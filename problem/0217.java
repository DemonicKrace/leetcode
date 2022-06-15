class Solution {
    public boolean containsDuplicate(int[] nums) {
        // https://leetcode.com/problems/contains-duplicate/discuss/60937/3ms-Java-Solution-with-Bit-Manipulation
        // method 1
        Set<Integer> set = new HashSet();
        for (int n: nums) if(!set.add(n)) return true;        
        return false;
    }
}