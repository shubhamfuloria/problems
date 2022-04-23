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
    private int height(TreeNode root) {
        
        if(root == null) {
            return -1;
        }
        
        int l_height = height(root.left);
        int r_height = height(root.right);
        
        
        return Math.max(l_height, r_height) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        int l_diameter = diameterOfBinaryTree(root.left);
        int r_diameter = diameterOfBinaryTree(root.right);
        
        int factor = height(root.left) + height(root.right) + 2;
        
        return Math.max(factor, Math.max(l_diameter, r_diameter));
    }
}