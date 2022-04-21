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
    public int maxDepth(TreeNode root) {
//         return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

//         // dfs
//         if (root == null) {
//             return 0;
//         }
//         Stack<TreeNode> nodeStack = new Stack<TreeNode>();    
//         nodeStack.push(root);
//         Stack<Integer> valueStack = new Stack<Integer>();    
//         valueStack.push(1);
//         int mxDepth = 0;
//         while (!nodeStack.isEmpty()) {
//             TreeNode node = nodeStack.pop();
//             int depth = valueStack.pop();     
//             if (node.left != null) {
//                 nodeStack.push(node.left);
//                 valueStack.push(depth + 1);
//             } 
//             if (node.right != null) {
//                 nodeStack.push(node.right);                
//                 valueStack.push(depth + 1);
//             }
//             mxDepth = Math.max(mxDepth, depth);
//         }
//         return mxDepth;

//         // bfs
//         if (root == null) {
//             return 0;
//         }
//         Queue<TreeNode> que = new LinkedList<TreeNode>();
//         que.offer(root);
//         int count = 0;
//         while (!que.isEmpty()) {
//             int size = que.size();
//             while (size-- > 0) {
//                 TreeNode node = que.poll();
//                 if (node.left != null) {
//                     que.offer(node.left);
//                 }
//                 if (node.right != null) {
//                     que.offer(node.right);
//                 }
//             }        
//             count++;
//         }
//         return count;
    }
}