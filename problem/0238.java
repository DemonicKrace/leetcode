class Solution {
    public int[] productExceptSelf(int[] nums) {
        // https://leetcode.com/problems/product-of-array-except-self/discuss/65622/Simple-Java-solution-in-O(n)-without-extra-space
        int[] res = new int[nums.length];
        int left = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // update left numbers product
            left *= nums[i - 1];
            // store preivous numbers product
            res[i] = left;
        }
        int right = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            // update right numbers product
            right *= nums[j + 1];
            // multiply the remaining right numbers product
            res[j] *= right;
        }
        return res;
    }
}