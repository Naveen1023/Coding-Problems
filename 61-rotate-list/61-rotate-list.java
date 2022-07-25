/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int findLength(ListNode node){
        int res = 0;
        while(node!=null) {
            res++;
            node = node.next;
        }
        return res;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int len = findLength(head);
        k = k % len;
        if(k == 0 ) return head;
        
        // go to kth node from last 
        
        ListNode s = head, f = head , prev = null , last = null;
        for(int i=0;i<k;i++){
            f = f.next;
        }
        while(f != null){
            prev = s;
            s = s.next;
            last = f;
            f = f.next;
        }
        prev.next = null;
        last.next = head;
        head = s;
        return head;
    }
}

























