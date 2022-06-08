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
    public int height(TreeNode root) {
        if(root == null) {
            return -1;
        }
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        int left_dia = diameterOfBinaryTree(root.left);
        int right_dia = diameterOfBinaryTree(root.right);
        
        int root_dia = height(root.left) + height(root.right) + 2;
        
        return Math.max(left_dia, Math.max(right_dia, root_dia));
    }
}