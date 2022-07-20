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

    private Integer prev;
    
    public boolean isValidBST(TreeNode root) {
        // https://leetcode.com/problems/validate-binary-search-tree/solution/
        
        // // method 1, recursive, time = O(N), space = O(N)
        // return valid(root, null, null);
        
        // method 2, recursive inorder, time = O(N), space = O(N)
        prev = null;
        return inorder(root);
    }
    
    // private boolean valid(TreeNode node, Integer min, Integer max) {
    //     if (node == null) return true;
    //     if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
    //     return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    // }
    
    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}