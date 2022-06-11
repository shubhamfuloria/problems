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
    
    
    public int getInIndex(int[] in, int start, int end, int target) {
        
        for(int i = start; i <= end; i++) {
            if(in[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
    
    public TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        
        if(inStart > inEnd) {
            return null;
        }
        
        //the first element of preorder traversal will be root
        TreeNode root = new TreeNode(pre[preStart]);
        
        int rootIndex = getInIndex(in, inStart, inEnd, pre[preStart]);
        
        int leftSubtreeSize = rootIndex - inStart;
        int rightSubtreeSize = inEnd - rootIndex;
        
        root.left = buildTree(pre, preStart + 1, preStart  + leftSubtreeSize, in, inStart, rootIndex - 1);
        root.right = buildTree(pre, preEnd - rightSubtreeSize + 1, preEnd, in, rootIndex + 1, inEnd);
        
        return root;
        
    }
    
    public TreeNode buildTree(int[] pre, int[] in) {
            
        return buildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    
    }
}