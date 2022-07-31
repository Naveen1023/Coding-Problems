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
    public int maxAncestorDiff(TreeNode root) {
        res = 0;
        solve(root, Integer.MAX_VALUE, -1);
        return res;
    }
    public void solve(TreeNode node, int mini, int maxi){
        
        if(node == null) return ;
        
        if(node.val > maxi) maxi = node.val;
        if(node.val < mini) mini = node.val;
        
        // System.out.println(node.val+" "+mini+" "+maxi);
        
        solve(node.left, mini,maxi);
        solve(node.right, mini, maxi);
        
        res = Math.max(res, Math.abs(mini - maxi));
        
    }
    
}