class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, nums.length - 1, target, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int end, int target, int k) {
        List<List<Integer>> res = new ArrayList();
        if (start == end) return res;
        int avg = target / k;
        if (nums[start] > avg || nums[end] < avg) return res;
        if (k == 2) return twoSum(nums, start, end, target);
        for (int i = start; i < end; i++) {
            // check duplicated
            if (i != start && nums[i] == nums[i - 1]) continue;
            for (List<Integer> subset: kSum(nums, i + 1, end, target - nums[i], k - 1)) {
                List<Integer> row = new ArrayList();
                row.add(nums[i]);
                row.addAll(subset);
                res.add(row);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> res = new ArrayList();
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                res.add(Arrays.asList(nums[start], nums[end]));
                while (start < end && nums[start] == nums[start + 1]) start++;
                while (start < end && nums[end] == nums[end - 1]) end--;
                start++; end--;
            }
            else if (nums[start] + nums[end] < target) start++;
            else end--;
        }
        return res;
    }
}