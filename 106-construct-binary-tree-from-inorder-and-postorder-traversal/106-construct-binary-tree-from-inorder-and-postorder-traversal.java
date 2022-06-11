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

    int getIndex(int[] A, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }

    TreeNode buildTree(int[] post, int postStart, int postEnd, int[] in, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        // last element of postorder traversal will be root

        TreeNode root = new TreeNode(post[postEnd]);

        int rootIndex = getIndex(in, inStart, inEnd, root.val);

        int leftSubtreeSize = rootIndex - inStart;
        int rightSubTreeSize = inEnd - rootIndex;

        root.left = buildTree(post, postStart, postStart + leftSubtreeSize - 1, in, inStart, rootIndex - 1);
        root.right = buildTree(post, postStart + leftSubtreeSize, postEnd - 1, in, rootIndex + 1, inEnd);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
