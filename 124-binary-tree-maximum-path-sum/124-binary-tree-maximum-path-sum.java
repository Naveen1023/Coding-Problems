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
        
        int left = Math.max(0,solve(node.left));
        int right = Math.max(0,solve(node.right));
        
        // if(node.left != null) path2 += left;
        // if(node.right != null) path2 += right;
        
        res = Math.max(res, node.val+left+right);
        
        //if(left<0)left=0;
        //if(right<0) right=0;
        return node.val+Math.max(left,right);
    }
}






