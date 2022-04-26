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
    
    static boolean balanced;
    
    private int calculaltesBalancedReturnsHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int l_height = calculaltesBalancedReturnsHeight(root.left);
        int r_height = calculaltesBalancedReturnsHeight(root.right);
        
        if(Math.abs(l_height - r_height) >= 2) {
            balanced = false;
        }
        
        return Math.max(l_height, r_height) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        calculaltesBalancedReturnsHeight(root);
        return balanced;
    }
}