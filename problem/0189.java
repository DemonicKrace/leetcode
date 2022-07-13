class Solution {
    public void rotate(int[] nums, int k) {
        // method 1, reverse, time = O(N), space = O(1)
        k %= nums.length;
        // reverse all
        // ex: =====>==> -> <==<=====
        reverse(nums, 0, nums.length - 1);
        // reverse rotate part
        // ex: <==<===== -> ==><=====
        reverse(nums, 0, k - 1);
        // reverse remaining part
        // ex: ==><===== -> ==>=====>
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}