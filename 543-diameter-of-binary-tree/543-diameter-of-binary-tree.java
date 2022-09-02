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
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        
        solve(root);
        return res;
        
    }
    public int solve(TreeNode node){
        
        if(node == null) return 0;
        
        int l = solve(node.left);
        int r=  solve(node.right);
        
        res = Math.max(res, l + r);
        
        return 1 + Math.max(l,r);
        
    }
    
}