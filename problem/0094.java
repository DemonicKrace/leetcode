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
    // List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        // // method 1, revursive, time = O(N), space = O(N), N = nodes count
        // result = new ArrayList();
        // recurInorderTraversal(root);
        // return result;
        
        // method 2, revursive, time = O(N), space = O(N), N = nodes count
        List<Integer> result = new ArrayList();
        Deque<TreeNode> stack = new ArrayDeque();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
    
    // private void recurInorderTraversal(TreeNode root) {
    //     if (root == null) return;
    //     recurInorderTraversal(root.left);
    //     result.add(root.val);
    //     recurInorderTraversal(root.right);
    // }
}