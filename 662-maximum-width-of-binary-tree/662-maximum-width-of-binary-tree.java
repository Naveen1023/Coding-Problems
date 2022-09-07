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
 
 
 
 1
 2 3
 4 5 6 7
 
 
 1 | 3| 2| 5| 3| | 9| 
 1   2  3  4  5 6  7
 */
class Node {
    TreeNode node;
    int index;
    Node(TreeNode n, int i){
        node = n;
        index = i;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> q = new LinkedList<>();
        
        q.offer(new Node(root, 1));
        
        int res = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            int first =0,last = 0;
            // System.out.println("size = "+size);
            
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                if(i == 0) {
                    first = curr.index;
                }
                if(i == size-1){
                    last = curr.index;
                }
                if(curr.node.left != null) q.offer(new Node(curr.node.left, 2*curr.index));
                if(curr.node.right != null) q.offer(new Node(curr.node.right, 2*curr.index + 1));
                
            }
            // System.out.println(first+" "+last);
            res = Math.max(res, last - first + 1);
            
        }
        return res;
    }
}