class Solution {
    public int longestConsecutive(int[] nums) {
        // // method 1, sorted, time = O(NlogN), space = O(1)
        // int n = nums.length;
        // if (n == 0) return 0;
        // Arrays.sort(nums);
        // int maxLength = 1;
        // int curLength = 1;
        // for (int i = 0; i < n - 1; i++) {
        //     // if next number is same, not do anthing
        //     if (nums[i] != nums[i + 1]) {
        //         if (nums[i] + 1 == nums[i + 1]) {
        //             // if next number is plus one
        //             curLength++;
        //         } else {
        //             // reset
        //             curLength = 1;
        //         }
        //         maxLength = Math.max(maxLength, curLength);
        //     }
        // }
        // return maxLength;
        
        // method 2, use set, time = O(N), Space = O(N)
        Set<Integer> set = new HashSet<Integer>();
        for (int n: nums) set.add(n);
        int maxLength = 0;
        for (int n: set) {
            // check current number is a start number
            if (!set.contains(n - 1)) {
                int curLength = 1;
                int curNum = n + 1;
                while (set.contains(curNum++)) curLength++;
                maxLength = Math.max(maxLength, curLength);
            }
        }
        return maxLength;
    }
}