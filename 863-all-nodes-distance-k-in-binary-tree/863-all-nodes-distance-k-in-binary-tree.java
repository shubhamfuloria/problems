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

    public static List<TreeNode> nodeToRootPath(TreeNode root, TreeNode target) {
        if (root == null) {
            return null;
        }

        if (root == target) {
            return new ArrayList<>(Arrays.asList(root));
        }

        List<TreeNode> leftPath = nodeToRootPath(root.left, target);
        if (leftPath != null) {
            leftPath.add(root);
            return leftPath;
        }

        List<TreeNode> rightPath = nodeToRootPath(root.right, target);
        if (rightPath != null) {
            rightPath.add(root);
            return rightPath;
        }

        return null;
    }

    public static void getKLevelsDown(TreeNode root, int k, TreeNode blocker, List<Integer> res) {
        if (root == null || root == blocker) {
            return;
        }
        if (k == 0) {
            res.add(root.val);
        }

        getKLevelsDown(root.left, k - 1, blocker, res);
        getKLevelsDown(root.right, k - 1, blocker, res);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> path = nodeToRootPath(root, target);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            TreeNode blocker = i == 0 ? null : path.get(i - 1);
            getKLevelsDown(path.get(i), k - i, blocker, res);
        }

        return res;
    }
}
