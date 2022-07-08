// 2022-05-12
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

// 2022-07-08
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList();
        for (int first = 0; first < n - 2; first++) {
            // check first element not dupilcated
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                if (nums[second] + nums[third] > -nums[first]) third--;
                else if (nums[second] + nums[third] < -nums[first]) second++;
                else {
                    result.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    second++;
                    third--;
                    // check next element not duplicated
                    while (second < third && nums[second] == nums[second - 1]) second++;
                    while (second < third && nums[third] == nums[third + 1]) third--;                    
                }
            }
        }
        return result;
    }    
}
