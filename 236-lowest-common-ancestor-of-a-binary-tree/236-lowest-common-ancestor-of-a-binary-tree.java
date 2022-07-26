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
        res= null;
        return lca(root, p, q);
    }
    
    public TreeNode lca(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return null;
        
        if(node == p || node == q) return node;
        
        TreeNode l = lca(node.left, p, q);
        TreeNode r = lca(node.right, p ,q);
        
        // if(l != null && r != null) {
        //     res = node;
        // }
        if(l == null) return r;
        else if(r == null) return l;
        
        return node;
        
    }
    
}