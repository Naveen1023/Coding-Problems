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
    static TreeNode prev;
    static int count;
    static int maxFreq;

    public int[] findMode(TreeNode root) {
        prev = null;
        count = 0;
        maxFreq = 1;

        List<Integer> list = new ArrayList<>();

        solve(root, list);
        int res[] = new int[list.size()];
        int i = 0;

        for (int ele : list)
            res[i++] = ele;

        return res;
    }

    private static void solve(TreeNode node, List<Integer> list) {

        if (node == null)
            return;

        solve(node.left, list);

        if (prev == null || node.val == prev.val) {
            count++;
        } else
            count = 1;

        if (count == maxFreq) {
            list.add(node.val);
        } else if (count > maxFreq) {
            maxFreq = count;
            list.clear();
            list.add(node.val);
        }

        // System.out.println("node.val : "+node.val+", cnt : "+count+", maxFreq : "+maxFreq);
        prev = node;
        solve(node.right, list);

    }
}