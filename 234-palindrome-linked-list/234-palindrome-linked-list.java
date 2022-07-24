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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        
        ListNode s = head, f =head; 
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        ListNode temp = head, prev = null;
        while(temp != s){
            ListNode nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        }
        
        if(f != null) s = s.next; // odd length LL
        
        
        while(s != null){
            if(prev.val != s.val) return false;
            prev = prev.next;
            s = s.next;
        }
        return true;
    }
}