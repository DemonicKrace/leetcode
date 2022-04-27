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
    // List<List<TreeNode>> dp;
    Map<Integer, List<TreeNode>> dp = new HashMap();

    public List<TreeNode> allPossibleFBT(int n) {
        // // method 1, dp with List
        // if (dp == null) {
        //     dp = new ArrayList<List<TreeNode>>(n + 1);
        //     dp.add(0, new ArrayList<TreeNode>());
        //     dp.add(1, new ArrayList<TreeNode>(){{add(new TreeNode());}});
        //     dp.add(2, new ArrayList<TreeNode>());
        //     dp.add(3, new ArrayList<TreeNode>(){{add(new TreeNode(0, new TreeNode(), new TreeNode()));}});
        // }
        // if (dp.size() > n && dp.get(n) != null) return dp.get(n);
        // List<TreeNode> res = new ArrayList<TreeNode>();
        // if (n % 2 == 0) return res;
        // for (int i = 0; i < n - 2; i += 2) {
        //     for (TreeNode leftRoot: allPossibleFBT(n - 2 - i)) {
        //         for (TreeNode rightRoot: allPossibleFBT(i + 1)) {
        //             TreeNode root = new TreeNode();
        //             root.left = leftRoot;
        //             root.right = rightRoot;
        //             res.add(root);  
        //         }
        //     }
        // }        
        // return res;

        // method 2, dp with Map
        if (dp.containsKey(n)) return dp.get(n);
        if (n % 2 == 0) return new ArrayList<TreeNode>();
        if (n == 1) return new ArrayList<TreeNode>(){{add(new TreeNode());}};  
        List<TreeNode> res = new ArrayList<TreeNode>();
        for (int i = 0; i < n - 2; i += 2) {
            for (TreeNode leftRoot: allPossibleFBT(n - 2 - i)) {
                for (TreeNode rightRoot: allPossibleFBT(i + 1)) {
                    TreeNode root = new TreeNode();
                    root.left = leftRoot;
                    root.right = rightRoot;
                    res.add(root);  
                }
            }
        }
        dp.put(n, res);
        return dp.get(n);
    }
}