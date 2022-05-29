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
    public List<Integer> preorderTraversal(TreeNode root) {
     
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> res = new ArrayList<>();
        
        if(root == null) {
            return res;
        }
        
        stk.add(root);
        
        
        
        while(stk.empty() == false) {
            
            TreeNode node = stk.pop();
            res.add(node.val);
            
            if(node.right != null) {
                stk.push(node.right);
            }
            
            if(node.left != null) {
                stk.push(node.left);
            }
        }
        
        return res;
    }
}