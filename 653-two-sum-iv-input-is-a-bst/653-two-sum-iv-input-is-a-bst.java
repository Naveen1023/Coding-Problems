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
    
    HashSet<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        
        // logN * n => O(N * logN)
        
        
        // store in hashmap, go to every node, check if (target - node.val) exists in the map or not O(N) + O(n)  = O(N)
        // inorder traversal => sorted order => two pointers on both ends, search the target....
        
        return solve(root,k);
    }
    
    public boolean solve(TreeNode node, int target){
        
        if(node == null) return false;
        
        boolean l = solve(node.left, target);
        if(set.contains(target-node.val)) return true;
        set.add(node.val);
        
        boolean r = solve(node.right, target);
        
        return l || r;
    }
    
}