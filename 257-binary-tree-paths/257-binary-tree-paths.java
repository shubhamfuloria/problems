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

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            return new ArrayList<>(Arrays.asList(root.val + ""));
        }

        List<String> leftLeafPaths = binaryTreePaths(root.left);
        List<String> rightLeafPaths = binaryTreePaths(root.right);

        List<String> res = new ArrayList<>();

        for (String el : leftLeafPaths) {
            String str = root.val + "->" + el;
            res.add(str);
        }

        for (String el : rightLeafPaths) {
            String str = root.val + "->" + el;
            res.add(str);
        }

        return res;
    }
}
