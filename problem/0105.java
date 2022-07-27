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
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // // method 1, recursive with inorder index map, time = O(N), space = O(N)
        // inorderIndexMap = new HashMap();
        // for (int i = 0; i < inorder.length; i++) inorderIndexMap.put(inorder[i], i);        
        // return buildRecur(preorder, 0, 0, inorder.length - 1);
        
        // offical solution
        // method 2, recursive with inorder index map, time = O(N), space = O(N)
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }
    
    // private TreeNode buildRecur(int[] preorder, int root, int left, int right) {
    //     if (left > right) return null;
    //     TreeNode node = new TreeNode(preorder[root]);
    //     int mid = inorderIndexMap.get(preorder[root]);
    //     // root next value is the left part root value
    //     node.left = buildRecur(preorder, root + 1, left, mid - 1);
    //     // root move (mid - left + 1) is the right part root value
    //     node.right = buildRecur(preorder, root + mid - left + 1, mid + 1, right);
    //     return node;
    // }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}