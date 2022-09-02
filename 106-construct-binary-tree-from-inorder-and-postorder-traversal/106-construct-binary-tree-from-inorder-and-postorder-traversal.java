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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return solve(0,postorder.length-1, 0,inorder.length-1, postorder, map);
        
    }
    public TreeNode solve(int ps, int pe, int is, int ie, int post[], HashMap<Integer, Integer> map){
        
        if(ps > pe || is > ie) return null;
        
        TreeNode node = new TreeNode(post[pe]);
        
        int index = map.get(post[pe]);
        
        int leftSide = index - is;
        int rightSide = ie - index;
        
        node.left = solve(ps, ps+leftSide-1, is, index-1, post, map);
        node.right = solve(ps+leftSide, pe-1,index+1,ie, post, map);
        
        return node;
        
    }
}