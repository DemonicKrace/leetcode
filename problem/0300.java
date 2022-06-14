class Solution {
    public int lengthOfLIS(int[] nums) {  
        // // method 1, dp
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp, 1);
        // int max = 0;
        // for (int i = 0; i < nums.length; i++) 
        //     for (int j = 0; j < i; j++) 
        //         if (nums[i] > nums[j] && dp[i] < dp[j] + 1) 
        //             dp[i] = dp[j] + 1;
        // return Arrays.stream(dp).max().getAsInt();
        
        // method 2, greedy and binary search
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int last = temp.get(temp.size() - 1);
            if (nums[i] > last) {
                temp.add(nums[i]);
            } else if (nums[i] < last) {
                // if number not found, return the negative inserted position - 1 (Ex: list=[1,3,5], num=2, return -2 - 1 = -3)
                int index = Collections.binarySearch(temp, nums[i]);
                int pos = (index < 0) ? Math.abs(index + 1) : index;
                temp.set(pos, nums[i]);
            }
        }
        return temp.size();
    }
}