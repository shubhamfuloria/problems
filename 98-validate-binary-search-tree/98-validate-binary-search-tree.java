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

    static class PairBST {
        boolean isBST;
        long min;
        long max;
    }

    private static PairBST helper(TreeNode root) {
        if (root == null) {
            PairBST mp = new PairBST();
            mp.isBST = true;
            mp.min = Long.MAX_VALUE;
            mp.max = Long.MIN_VALUE;
            return mp;
        }

        PairBST lp = helper(root.left);
        PairBST rp = helper(root.right);

        PairBST mp = new PairBST();
        mp.min = Math.min(root.val, Math.min(lp.min, rp.min));
        mp.max = Math.max(root.val, Math.max(lp.max, rp.max));
        mp.isBST = lp.isBST && rp.isBST && (lp.max < root.val) && (root.val < rp.min);

        return mp;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
}
