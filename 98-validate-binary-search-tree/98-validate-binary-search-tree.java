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

    private static long maxInBtree(TreeNode root) {
        if (root == null) {
            return Long.MIN_VALUE;
        }

        long l_max = maxInBtree(root.left);
        long r_max = maxInBtree(root.right);

        return Math.max(root.val, Math.max(l_max, r_max));
    }

    private static long minInBtree(TreeNode root) {
        if (root == null) {
            return Long.MAX_VALUE;
        }

        long l_min = minInBtree(root.left);
        long r_min = minInBtree(root.right);

        return Math.min(root.val, Math.min(l_min, r_min));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isLeftSubtreeBST = isValidBST(root.left);
        boolean isRightSubtreeBST = isValidBST(root.right);

        long maxInLSubtree = maxInBtree(root.left);
        long minInRSubtree = minInBtree(root.right);

        return isLeftSubtreeBST && isRightSubtreeBST && (maxInLSubtree < root.val) && (root.val < minInRSubtree);
    }
}
