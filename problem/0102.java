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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // method 1, BFS, time = O(N), space = O(M), M = max nodes level
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> que = new ArrayDeque();
        if (root != null) que.add(root);
        while (!que.isEmpty()) {
            List<Integer> curLevel = new ArrayList();
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                curLevel.add(node.val);
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);                
            }
            result.add(curLevel);
        }
        return result;
    }
}