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
    public boolean isSymmetric(TreeNode root) {
        // https://leetcode.com/problems/symmetric-tree/discuss/433170/isMirror-DFS-(Recursion-OneTwo-Stacks)-%2B-BFS-(Queue)-Solution-in-Java
        // // method 1, BFS, time = O(N), space = O(M), M = max nodes level
        // Deque<TreeNode> deque = new ArrayDeque();
        // deque.add(root);
        // boolean isRoot = true;
        // while (!deque.isEmpty()) {
        //     int size = deque.size();
        //     if (!isRoot && size % 2 == 1) return false;
        //     Deque<TreeNode> leftQueue = new ArrayDeque();
        //     Deque<TreeNode> rightStack = new ArrayDeque();
        //     size = deque.size();
        //     while (size > 0) {
        //         if (isRoot) {
        //             TreeNode node = deque.poll();
        //             if (node.left == null && node.right == null) return true;
        //             if (node.left != null) deque.add(node.left);
        //             if (node.right != null) deque.add(node.right);
        //             break;
        //         }
        //         TreeNode leftNode = deque.poll();
        //         TreeNode rightNode = deque.removeLast();
        //         if (leftNode.val != rightNode.val) return false;
        //         if ((leftNode.left == null && rightNode.right != null) || (leftNode.left != null && rightNode.right == null)) return false;
        //         if ((leftNode.right == null && rightNode.left != null) || (leftNode.right != null && rightNode.left == null)) return false;
        //         if (leftNode.left != null) leftQueue.add(leftNode.left);
        //         if (leftNode.right != null) leftQueue.add(leftNode.right);
        //         if (rightNode.right != null) rightStack.push(rightNode.right);
        //         if (rightNode.left != null) rightStack.push(rightNode.left);
        //         size -= 2;
        //     }
        //     while (!leftQueue.isEmpty()) deque.add(leftQueue.poll());
        //     while (!rightStack.isEmpty()) deque.add(rightStack.pop());
        //     if (isRoot) isRoot = false;
        // }
        // return true;
        
        // // method 2, BFS, time = O(N), space = O(M), M = max nodes level
        // Queue<TreeNode> que = new LinkedList();
        // que.offer(root.left);
        // que.offer(root.right);
        // while (!que.isEmpty()) {
        //     TreeNode left = que.poll();
        //     TreeNode right = que.poll();
        //     if (left == null && right == null) continue;
        //     if (left == null || right == null) return false;
        //     if (left.val != right.val) return false;
        //     que.offer(left.left);
        //     que.offer(right.right);
        //     que.offer(left.right);
        //     que.offer(right.left);
        // }
        // return true;
        
        // method 3, recursive, time = O(N), space = O(N)
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}