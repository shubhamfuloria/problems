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
    private int max_diameter = Integer.MIN_VALUE;
    
    private int calculatesDiameterReturnsHeight(TreeNode root) {
        
        if(root == null) {
            return -1;
        }
        
        int l_height = calculatesDiameterReturnsHeight(root.left);
        int r_height = calculatesDiameterReturnsHeight(root.right);
        
        int curr_diameter = l_height + r_height + 2;
        
        max_diameter = Math.max(curr_diameter, max_diameter);
        
        return Math.max(l_height, r_height) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        calculatesDiameterReturnsHeight(root);
        
        return max_diameter;
    }
}