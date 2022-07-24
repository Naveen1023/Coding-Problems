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
    HashMap<TreeNode,Integer> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return solve(root);
    }
    
    public int solve(TreeNode node){
        if(node == null) return 0;
        int pick = node.val;
        
        if(map.containsKey(node)) return map.get(node);
        
        if(node.left != null) pick += solve(node.left.left) + solve(node.left.right);
        if(node.right != null) pick += solve(node.right.left) + solve(node.right.right);
        
        int notPick = solve(node.left) + solve(node.right);
        
        int res =  Math.max(pick , notPick);
        map.put(node, res);
        return res;
    }
}