/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    public TreeNode find(TreeNode root, TreeNode target) {
        
        if(root == null) {
            return root;
        }
        
        if(root.val == target.val) {
            return root;
        }
        
        TreeNode leftSearch = find(root.left, target);
        
        if(leftSearch != null) {
            return leftSearch;
        }
        
        TreeNode rightSearch = find(root.right, target);
        
        if(rightSearch != null) {
            return rightSearch;
        }
        
        return null;
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        TreeNode res = find(cloned, target);
        return res;
    }
}