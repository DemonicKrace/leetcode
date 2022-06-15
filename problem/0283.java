class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, curNoneZeroIndex = 0; i < nums.length; i++) {
            if (nums[i] != 0) swap(nums, i, curNoneZeroIndex++); 
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}