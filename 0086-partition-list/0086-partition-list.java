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
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode targetNode = head, targetPrev = start;

        //find out a point before which you need to move nodes. point >= x

        while(targetNode != null) {
            if(targetNode.val >= x) break;
            targetPrev = targetNode;
            targetNode = targetNode.next;
        }

        ListNode currNode = targetNode, currPrev = targetPrev;

        while(currNode != null) {
            if(currNode.val < x) { // means it needs to be deleted and inserted at target location 
                
                deleteNode(currNode, currPrev);
                insertNodeAndUpdate(currNode, targetNode, targetPrev);
                targetPrev = currNode;
            }
            else {
                currPrev = currNode;
            }
            currNode = currNode.next;
        }

        return start.next;
    }

    private void deleteNode(ListNode node, ListNode prev) {
        prev.next = node.next;
    }

    private void insertNodeAndUpdate(ListNode node, ListNode targetNode, ListNode targetPrev) {
        node.next = targetPrev.next;
        targetPrev.next = node;
    }
}

// start -> 1 ->(2) ->  4 -> 3 -> 2 -> 5 -> 2