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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        // go to depth-1 
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int temp = depth-1;
        while(temp-- > 1){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode curr = q.poll();
                
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }  
            }
        }
        
        // we are at previous level...create left and right child...save original left,right
        // then add new left/right...and append original left/right to new left/right
        
        while(!q.isEmpty()){
            
            //saving original children
            TreeNode node = q.poll();
            TreeNode orgLeft = node.left;
            TreeNode orgRight = node.right;
            
            // creating new left and right
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            
            // adding new nodes as children 
            node.left = newLeft;
            node.right = newRight;
                
            // appending if original nodes are not null
            if(orgLeft != null) node.left.left = orgLeft;
            if(orgRight != null) node.right.right = orgRight;
            
        }
        
        return root;
        
        
    }
}