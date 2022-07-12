class Solution {
    public int singleNumber(int[] nums) {
        // // method 1, XOR, time = O(N), space = O(1)
        // int result = 0;
        // for (int num: nums) result ^= num;
        // return result;
        
        // // method 2, HashSet, time = O(N), space = O(N)
        // Set<Integer> set = new HashSet();
        // for (int num : nums)
        //     if (set.contains(num)) set.remove(num);
        //     else set.add (num);
        // return set.iterator().next();
        
        // method 3, Sort, time = O(NlogN), space = O(1)
        Arrays.sort(nums);
        int single = 0;
        for (int i = 0; i < nums.length; i += 2) {
            single = nums[i];            
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) break;
        }
        return single;
    }
}