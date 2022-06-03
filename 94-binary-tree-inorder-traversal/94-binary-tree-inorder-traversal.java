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
        public TreeNode node;
        public int state;

        public Pair(TreeNode node) {
            this.node = node;
            this.state = 1;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        
        if(root == null) {
            return res;
        }
        
        Stack<Pair> stk = new Stack<>();
        
        stk.push(new Pair(root));
        
        while(stk.empty() == false) {
            
            Pair top = stk.peek();
            
            if(top.state == 1) {
                if(top.node.left != null) {
                    stk.push(new Pair(top.node.left));
                }
                top.state++;
            } else if(top.state == 2) {
                res.add(top.node.val);
                if(top.node.right != null) {
                    stk.push(new Pair(top.node.right));
                }
                top.state++;
            } else {
                stk.pop();
            }
        }
        
        return res;
    }
}
