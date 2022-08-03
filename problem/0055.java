class Solution {
    public boolean canJump(int[] nums) {
        // method 1, DP, time = O(N), space = O(1)
        int n = nums.length, curFar = 0, maxFar = 0;
        for (int i = 0; i < n; i++) {
            // check current index in maxFar
            if (i > maxFar) return false;
            curFar = i + nums[i];
            // check curFar can reach end
            if (curFar >= n - 1) return true;
            // update maxFar
            maxFar = Math.max(maxFar, curFar);
        }
        return false;
    }
}