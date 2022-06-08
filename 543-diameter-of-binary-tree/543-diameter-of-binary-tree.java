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
    
    private static int diameter;
    
    public int calculatesDiameterReturnsHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }
        
        int left_height = calculatesDiameterReturnsHeight(root.left);
        int right_height = calculatesDiameterReturnsHeight(root.right);
        
        diameter = Math.max(diameter, left_height + right_height + 2);
        
        return Math.max(left_height, right_height) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        calculatesDiameterReturnsHeight(root);
        return diameter;
    }
}