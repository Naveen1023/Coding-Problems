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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-101);   
        
        dummy.next = head;
        ListNode n1 = dummy;
        ListNode n2 = head;  // iterate over the list...
        
        ListNode prev = dummy;
        
        while(n2!=null){
            if(n2.val < x){
                
                if(n2 == n1.next){
                    n1 = n2;
                    prev = n2;
                    n2 = n2.next;
                    continue;
                }
                ListNode temp = n2;
                prev.next = n2.next;
                temp.next = n1.next;
                n1.next = temp;
                n1 = n1.next;
                n2 = prev.next;
                continue;
            }
            prev = n2;
            n2= n2.next;
        }
        
       return dummy.next;
    }
}








