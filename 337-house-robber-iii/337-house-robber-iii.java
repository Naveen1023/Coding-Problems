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
    HashMap<TreeNode, HashMap<Integer, Integer>> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        return solve(root ,1);
    }
    
    public int solve(TreeNode node, int pick){
        if(node == null) return 0;
        int ans = 0;
        if(map.containsKey(node) && map.get(node).containsKey(pick)) return map.get(node).get(pick);
        if(pick == 1){
            ans = Math.max(node.val + solve(node.left, 0) + solve(node.right, 0) , 
                          solve(node.left, 1) + solve(node.right,1));
        }
        else {
            ans = solve(node.left, 1) + solve(node.right, 1);
        }
        map.put(node, new HashMap<>());
        map.get(node).put(pick, ans);
        return ans;
    }
}