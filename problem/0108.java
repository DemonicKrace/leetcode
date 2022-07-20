/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // method 1, time = O(N), space = O(N)
        return toBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode toBST(int[] nums, int low, int high) {
        if (low > high) return null;
        TreeNode root = new TreeNode();        
        int mid = (low + high) / 2;
        root.val = nums[mid];
        root.left = toBST(nums, low, mid - 1);
        root.right = toBST(nums, mid + 1, high);
        return root;
    }
}