class Solution {
    public void wiggleSort(int[] nums) {
        // https://leetcode.com/problems/wiggle-sort-ii/discuss/77682/Step-by-step-explanation-of-index-mapping-in-Java
        int n = nums.length;
        int median = findKthLargest(nums, (n + 1) / 2);
        int left = 0;
        int right = n - 1;
        for (int i = 0; i <= right; ) {
            int vIndex = newIndex(i, n);
            if (nums[vIndex] > median) {
                swap(nums, vIndex, newIndex(left++, n));
                i++;
            } else if (nums[vIndex] < median) {
                swap(nums, vIndex, newIndex(right--, n));
            } else {
                i++;
            }
        }
    }
    
    private int newIndex (int index, int n) {
        // (n | 1) => if n is even than n = n + 1
        return (1 + 2 * index) % (n | 1);
    }
    
    private int findKthLargest (int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        int pivotIndex = partition(nums, left, right, (left + right) / 2);
        if (pivotIndex == k) return nums[k];
        if (k < pivotIndex) return quickSelect(nums, left, pivotIndex - 1, k);
        return quickSelect(nums, pivotIndex + 1, right, k);
    }
    
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        // swap pivot and right
        swap(nums, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            // move number to left which smaller than pviot
            if (nums[i] < pivot) swap(nums, i, storeIndex++);
        }
        // swap pivot to last store position
        swap(nums, storeIndex, right);
        return storeIndex;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }  
}