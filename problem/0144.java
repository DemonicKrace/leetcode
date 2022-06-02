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

 // my version
class Solution {
    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res.size() == 0 ? res : null;            
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);   
        return res;
    }
}