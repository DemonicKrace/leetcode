class Solution {
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> permute(int[] nums) {
        // method 1
        boolean[] numsRecord = new boolean[nums.length];
        dfs(new ArrayList(), nums, numsRecord);
        return res;
    }
            
    private void dfs(List<Integer> temp, int[] nums, boolean[] numsRecord) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!numsRecord[i]) {
                temp.add(nums[i]);
                numsRecord[i] = true;
                dfs(temp, nums, numsRecord);
                temp.remove(temp.size() - 1);
                numsRecord[i] = false;                
            } 
        }
    }
}