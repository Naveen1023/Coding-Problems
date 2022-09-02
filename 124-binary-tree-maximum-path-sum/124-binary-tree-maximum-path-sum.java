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
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        solve(root);
        return res;
    }
    public int solve(TreeNode node){
        
        if(node == null) return 0;
        
        int l = solve(node.left);
        int r = solve(node.right);
        
        
        
        int maxi = Math.max(l,r);
        
        int path1 = node.val;
        int path2 = node.val + maxi;
        int path3 = node.val + l + r;
        
        int maxPath = Math.max(path1, Math.max(path2, path3));
        res = Math.max(res , maxPath);  
        
        // System.out.println(node.val+" "+l+" "+r+" res= "+res);
        
        return Math.max(path1, path2);
        
        
    }
    
}