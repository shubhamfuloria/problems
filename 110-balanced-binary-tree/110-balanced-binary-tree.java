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

    static class BalPair {
        boolean isBalanced;
        int height;
    }

    private static BalPair isBalancedHelper(TreeNode root) {
        if (root == null) {
            BalPair mp = new BalPair();
            mp.isBalanced = true;
            mp.height = 0;
            return mp;
        }

        BalPair lp = isBalancedHelper(root.left);
        BalPair rp = isBalancedHelper(root.right);

        BalPair mp = new BalPair();
        mp.isBalanced = lp.isBalanced && rp.isBalanced && (Math.abs(lp.height - rp.height) < 2);
        mp.height = Math.max(lp.height, rp.height) + 1;

        return mp;
    }

    public boolean isBalanced(TreeNode root) {
        
        BalPair res = isBalancedHelper(root);
        return res.isBalanced;
    }
}
