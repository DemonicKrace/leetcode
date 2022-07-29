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

// 2022-07-29
class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> permute(int[] nums) {
        // method 1, backtrack, time = O(N!), space = O(N!)
        result = new ArrayList();
        backtrack(nums, new boolean[nums.length], new ArrayList());
        return result;
    }
    
    private void backtrack(int[] nums, boolean[] visited, List<Integer> row) {
        if (nums.length == row.size()) {
            result.add(new ArrayList(row));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            row.add(nums[i]);
            backtrack(nums, visited, row);
            row.remove(row.size() - 1);            
            visited[i] = false;
        }
    }
}