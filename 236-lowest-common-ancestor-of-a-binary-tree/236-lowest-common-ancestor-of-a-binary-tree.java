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

    private static List<TreeNode> rootToNodePath(TreeNode root, TreeNode target) {
        if (root == null) {
            return new ArrayList<>();
        } else if (root == target) {
            return new ArrayList<>(Arrays.asList(target));
        }

        List<TreeNode> l_path = rootToNodePath(root.left, target);
        List<TreeNode> r_path = rootToNodePath(root.right, target);

        if (l_path.size() > 0) {
            l_path.add(0, root);
            return l_path;
        } else if (r_path.size() > 0) {
            r_path.add(0, root);
            return r_path;
        } else {
            return new ArrayList<>();
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p1 = rootToNodePath(root, p);
        List<TreeNode> p2 = rootToNodePath(root, q);

        int i = 0;
        int j = 0;
        TreeNode lca = null;
        while (i < p1.size() && j < p2.size() && (p1.get(i) == p2.get(j))) {
            lca = p1.get(i++);
            j++;
        }

        return lca;
    }
}
