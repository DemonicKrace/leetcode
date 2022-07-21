class Solution {
    int[] orignal, current;
    Random rand;
    
    public Solution(int[] nums) {
        orignal = Arrays.copyOf(nums, nums.length);
        current = nums;
        rand = new Random();
    }
    
    public int[] reset() {
        return orignal;
    }
    
    public int[] shuffle() {
        for (int i = current.length - 1; i >= 0; i--) swap(current, rand.nextInt(i + 1), i);
        return current;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */