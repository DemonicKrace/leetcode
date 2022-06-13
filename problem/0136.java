class Solution {
    public int singleNumber(int[] nums) {
        // use xor, N ^ N => 0, M ^ N ^ N => M ^ 0 => M
        int result = 0;
        for (int num: nums) result ^= num;
        return result;
    }
}