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

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int curr_level = 0;
        int res_level = 1;
        int max_sum = Integer.MIN_VALUE;

        while (q.isEmpty() == false) {
            int size = q.size();
            int curr_sum = 0;
            curr_level++;
            for (int i = 0; i < size; i++) {
                TreeNode rem = q.poll();
                curr_sum += rem.val;

                if (rem.left != null) {
                    q.offer(rem.left);
                }

                if (rem.right != null) {
                    q.offer(rem.right);
                }
            }

            if (curr_sum > max_sum) {
                max_sum = curr_sum;
                res_level = curr_level;
            }
        }

        return res_level;
    }
}
