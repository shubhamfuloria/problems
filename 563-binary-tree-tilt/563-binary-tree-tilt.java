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
    static int t_tilt;
      public static int calculatesTiltReturnsHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int l_sum = calculatesTiltReturnsHeight(root.left);
    int r_sum = calculatesTiltReturnsHeight(root.right);

    t_tilt += Math.abs(l_sum - r_sum);

    return l_sum + r_sum + root.val;

  }
    public int findTilt(TreeNode root) {
        t_tilt = 0;
        
        calculatesTiltReturnsHeight(root);
        return t_tilt;
    }
}