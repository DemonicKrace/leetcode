class Solution {
    public int missingNumber(int[] nums) {
        // method 1, mathematic, time = O(N), space = O(1)
        // return (nums.length + 1) * nums.length / 2 - Arrays.stream(nums).sum();
        
        int sum = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        return (size + 1) * size / 2 - sum;
    }
}