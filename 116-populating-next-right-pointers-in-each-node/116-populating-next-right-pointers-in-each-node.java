/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
            
        Node node = root;
        
        while(node!=null){
            // System.out.println();
            Node temp = node;
            Node first = new Node(-1);
            Node prev = first;

            while(temp != null){
                 // System.out.print(temp.val+" ");
                if(temp.left != null){
                    prev.next = temp.left;
                    prev = prev.next;
                }
                if(node.right != null){
                    prev.next = temp.right;
                    prev= prev.next;
                }
                temp = temp.next;
            }     
           node = first.next; 
        }
        
        return root;
    }
}



















