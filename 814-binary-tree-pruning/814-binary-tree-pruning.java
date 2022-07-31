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
    public TreeNode pruneTree(TreeNode root) {
        return solve(root);
    }
    public TreeNode solve(TreeNode node){
     
        if(node == null) return null;
        TreeNode l = null,r = null;
        
        node.left = l = solve(node.left);
        node.right = r =  solve(node.right);
        
        if(node.val == 1 || l != null || r != null) return node;
        
        return null;
        
    }
}