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
    List<Integer> res;
    int depth;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        depth = -1;
        solve(root, 0);
        return res;
    }

    private void solve(TreeNode node, int currDepth) {
        if (node == null)
            return;

        if (currDepth > depth) {
            depth = currDepth;
            res.add(node.val);
        }
        solve(node.right, currDepth + 1);
        solve(node.left, currDepth + 1);
    }
}
/**
 */