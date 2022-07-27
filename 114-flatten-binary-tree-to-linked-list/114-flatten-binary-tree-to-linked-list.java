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
    public void flatten(TreeNode node) {
        if(node == null) return ;
        flatten(node.right);
        flatten(node.left);
        TreeNode tail = findTail(node.left);
            
        if(tail != null){
            tail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
    }
    public TreeNode findTail(TreeNode node){
        if(node == null) return null;
        while(node.right != null){
            node =  node.right;
        }
        return node;
    }
    
}