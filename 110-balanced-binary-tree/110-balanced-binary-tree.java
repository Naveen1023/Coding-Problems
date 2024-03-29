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
    boolean res;
    public boolean isBalanced(TreeNode root) {
        res = true;
        solve(root);
        
        return res;
    }
    
    public int solve(TreeNode node){
        
        if(node == null) return 0;
    
        int l = solve(node.left);
        int r = solve(node.right);
        
        if(Math.abs(l-r) > 1) res = false;
        
        return 1 + Math.max(l,r);
        
    }
    
}