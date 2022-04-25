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
    static int t_tilt = 0;

    public static int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + sum(root.left) + sum(root.right);
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        // tilt: sum of all left subtree nodes - sum of all right subtree nodes

        helper(root.left);
        helper(root.right);

        int curr_tilt = Math.abs(sum(root.left) - sum(root.right));
        t_tilt += curr_tilt;
    }

    public int findTilt(TreeNode root) {
        t_tilt = 0;
        helper(root);
        return t_tilt;
    }
}
