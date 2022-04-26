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
            return 0;
        }
        
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean isLeftSubtreeBalanced = isBalanced(root.left);
        boolean isRightSubtreeBalanced = isBalanced(root.right);
        boolean isRootBalanced = Math.abs(height(root.left) - height(root.right)) <= 1;
        
        return isLeftSubtreeBalanced && isRightSubtreeBalanced && isRootBalanced;
    }
}