class Solution {
    public int findKthLargest(int[] nums, int k) {
        // // method 1
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        
        // // method 2
        // PriorityQueue<Integer> pq = new PriorityQueue();
        // for (int i = 0; i < nums.length; i++) {
        //     pq.offer(nums[i]);
        //     if (pq.size() > k) pq.poll();    
        // }
        // return pq.peek();
        
        // method 3
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);        
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        int pivotIndex = partiton(nums, left, right, (left + right) / 2);        
        if (k == pivotIndex) return nums[k];
        if (k < pivotIndex) return quickSelect(nums, left, pivotIndex - 1, k);
        return quickSelect(nums, pivotIndex + 1, right, k);
    }
    
    private int partiton(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        // swap pivot, right
        // XOR swap will lead incorrect, when left-index equals right-index
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[right];
        nums[right] = temp;   
        int storeIndex = left;
        for (int i = left; i < right; i++) 
            if (nums[i] < pivot) {
                temp = nums[i];
                nums[i] = nums[storeIndex];
                nums[storeIndex] = temp;
                storeIndex++;
            }
        // swap pivot, right
        temp = nums[storeIndex];
        nums[storeIndex] = nums[right];
        nums[right] = temp;
        return storeIndex;
    }
}