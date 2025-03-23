class LRUCache {

    class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    int capacity;
    Node first, last;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        first = new Node(-1,-1);
        last = new Node(-1,-1);
        first.next = last;
        last.prev = first;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        insertAtLast(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) { // update the value
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAtLast(node);
        }
        else { // simply insert at Last
            Node node = new Node(key, value);
            map.put(key, node);
            insertAtLast(node);
        }

        // if capacity exceeds, need to delete the least receetly used, which is at first position
        if(map.size() > capacity) {
            Node lru = first.next;
            deleteNode(lru);
            map.remove(lru.key);
        }
    }

    public void moveToEnd(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if(prev!=null) prev.next = next;
        if(next != null) next.prev = prev;

        node.next = null;
        node.prev = null;
        insertAtLast(node);
    }

    public void insertAtLast(Node node) {
        node.prev = last.prev; 
        node.prev.next = node;
        node.next = last;
        last.prev = node;
    }

    public void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */