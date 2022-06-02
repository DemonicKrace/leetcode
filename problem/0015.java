class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // method 1
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size - 2; i++) {
            // check first element not duplicated
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1;
            int high = size - 1;
            while (low < high)
                if (nums[low] + nums[high] == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // check second element not duplicated
                    while (low < size - 1 && nums[low] == nums[low + 1]) low++;
                    // check third element not duplicated
                    while (high > 0 && nums[high] == nums[high - 1]) high--;
                    low++; high--;
                }
                else if (nums[low] + nums[high] < -nums[i]) low++;
                else high--;
        }
        return res;
    }
}