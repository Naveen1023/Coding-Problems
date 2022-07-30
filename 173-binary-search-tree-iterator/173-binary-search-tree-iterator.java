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
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushLeft(root);       
    }
    
    public int next() {
        TreeNode ans = st.pop();
        pushLeft(ans.right);
        return ans.val;
    }
    
    
    public boolean hasNext() {
        return (st.size() > 0) ? true : false;
    }
    
    public void pushLeft(TreeNode node){
        if(node == null) return ;
        while(node != null){
            st.push(node);
            node = node.left;
        } 
    }
    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */