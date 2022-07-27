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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // // method 1, BFS with queue, time = O(N^2), space = O(K), N = nodes count, K = max nodes count of level
        // List<List<Integer>> result = new ArrayList();
        // if (root == null) return result;
        // Deque<TreeNode> que = new ArrayDeque(){{add(root);}};
        // boolean isLeftward = true;
        // while (!que.isEmpty()) {
        //     List<Integer> row = new ArrayList();
        //     int size = que.size();
        //     while (size-- > 0) {
        //         TreeNode node = que.poll();
        //         row.add(node.val);
        //         if (node.left != null) que.add(node.left);
        //         if (node.right != null) que.add(node.right);
        //     }
        //     // reverse cost O(N) time complexity
        //     if (!isLeftward) Collections.reverse(row);
        //     result.add(row);
        //     isLeftward = !isLeftward;
        // }
        // return result;
        
        // // method 2, BFS with queue and linkedlist to append row data, time = O(N), space = O(K), N = nodes count, K = max nodes count of level
        // List<List<Integer>> result = new ArrayList();
        // if (root == null) return result;
        // Deque<TreeNode> que = new ArrayDeque(){{add(root);}};
        // boolean isLeftward = true;
        // while (!que.isEmpty()) {
        //     LinkedList<Integer> row = new LinkedList();
        //     int size = que.size();
        //     while (size-- > 0) {
        //         TreeNode node = que.poll();
        //         // use LinkedList to controll order
        //         if (isLeftward) row.add(node.val);
        //         else row.addFirst(node.val);
        //         if (node.left != null) que.add(node.left);
        //         if (node.right != null) que.add(node.right);
        //     }
        //     result.add(row);
        //     isLeftward = !isLeftward;
        // }
        // return result;
        
        // method 3, recursive, time = O(N^2), space = O(K), K = max depth of level
        List<List<Integer>> result = new ArrayList();
        if (root == null) return result;
        recurZigzagLevelOrder(result, root, 0);
        return result;
    }
    
    private void recurZigzagLevelOrder(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) return;
        // use LinkedList to controll order, addFirst() cost O(N) time complexity
        if (result.size() == level) result.add(new LinkedList());
        if (level % 2 == 0) result.get(level).add(root.val);
        else ((LinkedList)result.get(level)).addFirst(root.val);
        recurZigzagLevelOrder(result, root.left, level + 1);
        recurZigzagLevelOrder(result, root.right, level + 1);
    }
}