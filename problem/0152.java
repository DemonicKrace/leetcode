class Solution {
    public int maxProduct(int[] nums) {
        // https://leetcode.com/problems/maximum-product-subarray/discuss/1608862/JAVA-or-3-Solutions-or-Detailed-Explanation-Using-Image
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * tmp, nums[i] * min), nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}