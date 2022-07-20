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

class data {
    int sum;
    boolean bst;
    int maxLeft;
    int minRight;
    data(){
        
    }
    data(int s, boolean i, int max, int min){
        sum = s;bst = i;maxLeft = max;minRight = min;
    }
    
}

class Solution {
    int res;
    public int maxSumBST(TreeNode root) {
        res = 0;
        solve(root, false)        ;
        return res;
    }
    
    public data solve(TreeNode node, boolean left){
        
        if(node == null){
            return new data(0,true,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
        
        data l = solve(node.left,true);
        data r = solve(node.right, false);
                
        data temp = new data();
        
        if(l.bst == true && r.bst == true && l.maxLeft < node.val && node.val < r.minRight){
            temp.bst = true;
        }
        temp.sum = node.val + l.sum + r.sum;
        if(temp.bst == true ) res = Math.max(res, temp.sum);
        
        temp.maxLeft = Math.max(node.val, r.maxLeft);
        temp.minRight = Math.min(node.val,l.minRight);
        return temp;        
    }
    
}











