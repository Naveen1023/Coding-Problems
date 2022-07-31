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
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        return solve(root, p ,q);        
    }
    public TreeNode solve(TreeNode node, TreeNode p , TreeNode q){
        if(node == null) return null;
        if(node.val == p.val || node.val == q.val) return node;
        
        if(p.val < node.val && q.val < node.val) return solve(node.left, p, q);
        else if(p.val > node.val && q.val > node.val) return solve(node.right, p ,q);
        
        return node; 
    }
    
}