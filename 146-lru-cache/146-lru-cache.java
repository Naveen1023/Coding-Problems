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
    Node head, tail;
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
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
        // see if the key is repeated or not
        // repeated => update the value
        // if not => insert from scratch...
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addToHead(node);
        }
        else{
            // insert node at head location as it is most recent
            Node node = new Node(key, value);
            map.put(key,node);
            addToHead(node);
            
            if(map.size() > cap){
                //then remvoe the least used node which is at TAIL
                map.remove(tail.prev.key);
                deleteNode(tail.prev);  
                
            }
            
        }
    }
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void addToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev= head;
        head.next = node;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */