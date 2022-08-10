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
    public TreeNode sortedArrayToBST(int[] arr) {
        
        return solve(0,arr.length-1,arr);
        
    }
    public TreeNode solve(int i, int j, int arr[]){
        if(i > j) return null;
        
        int mid = (i+j)/2;
        
        // System.out.println(i+" "+j);
        TreeNode node = new TreeNode(arr[mid]);
        node.left = solve(i, mid-1, arr);
        node.right=  solve(mid+1,j,arr);
        
        return node;
    }
    
}