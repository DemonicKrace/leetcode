// 2022-05-12
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, nums.length - 1, target, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int end, long target, int k) {
        List<List<Integer>> res = new ArrayList();
        if (start == end) return res;
        long avg = target / k;
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

    private List<List<Integer>> twoSum(int[] nums, int start, int end, long target) {
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

// 2022-07-08
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }
    
    private List<List<Integer>> kSum(int[] nums, int start, long target, int k) {
        if (k == 2) return twoSum(nums, start, target);
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;
        // remaining not enough, average more than max or less than min 
        if ((n - start < k) || (target / k > nums[n - 1]) || (target / k < nums[start])) return result;
        for (int i = start; i < n; i++) {
            // check duplicated
            if (i > start && nums[i] == nums[i- 1]) continue;
            for (List<Integer> subset: kSum(nums, i + 1, target - nums[i], k - 1)) {
                List<Integer> list = new ArrayList();
                list.add(nums[i]);
                list.addAll(subset);
                result.add(list);
            }
        }
        return result;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int start, long target) {
        List<List<Integer>> result = new ArrayList();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) left++;
            else if (nums[left] + nums[right] > target) right--;
            else {
                result.add(Arrays.asList(nums[left++], nums[right--]));
                // check not duplicated
                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            }
        }
        return result;
    }
}