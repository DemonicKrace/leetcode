class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> r = new ArrayList<>();
        
        if (start == nums.length) {
            return r;
        }
        
        int avg = target / k;
        
        if (nums[start] > avg || avg > nums[nums.length - 1]) {
            return r;
        }
        
        if (k == 2) {
            return twoSum(nums, target, start);
        }
        
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                for (List<Integer> subset: kSum(nums, target - nums[i], i + 1, k - 1)) {
                    r.add(new ArrayList<>(List.of(nums[i])));
                    r.get(r.size() - 1).addAll(subset);
                }
            }
        }
        
        return r;
    }
    
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> r = new ArrayList<>();
        int low = start;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum > target || (high < nums.length - 1 && nums[high] == nums[high + 1])) {
                high--;
            } else if (sum < target || (low > start && nums[low] == nums[low - 1])) {
                low++;
            } else {
                r.add(new ArrayList<>(List.of(nums[low++], nums[high--])));
            }
        }
        return r;
    }
    
}