class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } 
            
            if (nums[mid] >= nums[left]) {
                // case A
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                // case A'
                } else {
                    left = mid + 1;
                }
            } else {
                // case B
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                // case B'
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}


// left(low) --- target(case A) --- mid(high) ---------------------- right(unknow)
// or 
// left(low) ---------------------- mid(high) --- target(case A') -- right(unknow)


// left(high) --------------------- mid(low) ---- target(case B) --- right(more low)
// or 
// left(high) -- target(case B') -- mid(low) ----------------------- right(more low)
