/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    static Map<Node, Node> map;

    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        Node temp = head;

        // create new nodes
        while (temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        // now copy the next and random pointers
        temp = head;
        while (temp != null) {
            Node newNode = map.get(temp);
            if (temp.next != null)
                newNode.next = map.get(temp.next);
            if (temp.random != null)
                newNode.random = map.get(temp.random);
            
            temp = temp.next;
        }

        if(head != null) return map.get(head);
        return null;
    }
}