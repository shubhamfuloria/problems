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

    static class Pair {
        int height;
        int diameter;

        public Pair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public Pair calculate(TreeNode root) {
        if (root == null) {
            return new Pair(-1, 0);
        }

        Pair l_hd = calculate(root.left);
        Pair r_hd = calculate(root.right);

        int root_dia = l_hd.height + r_hd.height + 2;

        int height = Math.max(l_hd.height, r_hd.height) + 1;
        int dia = Math.max(root_dia, Math.max(l_hd.diameter, r_hd.diameter));
        return new Pair(height, dia);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return calculate(root).diameter;
    }
}
