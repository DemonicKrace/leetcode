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
    int count = 0;
    int target = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        // // method 1, recursive, time = O(N), space = O(N + K), N = recursive used, K = array list used
        // return buildKthRecur(root, k, new ArrayList<Integer>()).get(k - 1);

        // method 1, recursive, time = O(N), space = O(N)
        buildKthRecur(root, k);
        return target;
        
        // // method 3, stack, time = O(N), space = O(H), H = tree height (worst case = N)
        // Deque<TreeNode> stack = new ArrayDeque();
        // while (root != null || !stack.isEmpty()) {
        //     while (root != null) {
        //         stack.push(root);
        //         root = root.left;
        //     }
        //     root = stack.pop();
        //     if (--k == 0) return root.val;
        //     root = root.right;
        // }
        // return -1;
    }

    // private void buildKthRecur(TreeNode root, int k, List<Integer> arr) {
    //     if (root == null || arr.size() == k) return;
    //     buildKthRecur(root.left, k, arr);
    //     arr.add(root.val);
    //     buildKthRecur(root.right, k, arr);
    // }
    
    private void buildKthRecur(TreeNode root, int k) {
        if (root == null) return;
        buildKthRecur(root.left, k);
        if (++count == k) {
            target = root.val;
            return;
        }
        buildKthRecur(root.right, k);
    }
}