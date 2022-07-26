class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int k, int v){
        this.key = k;
        this.val = v;
    }    
}

class LRUCache {
    int cap;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){ // just update the value...
            Node node = map.get(key);
            node.val = value; // update the priority as it is just now got used...
            deleteNode(node);
            addToHead(node);
        }
        else{ // we need to insert new node, and update it;s priority...
            Node node = new Node(key, value);
            map.put(key, node);
            if (map.size() <= cap) {
                // count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
     // head ==> 1  
    public void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev= head;
        head.next = node;
        
    }
    // 1==>2==>3
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */