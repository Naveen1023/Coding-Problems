/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashSet<Integer> vis;
    public Node cloneGraph(Node node) {
        
        if(node == null) return null;
        vis = new HashSet<>();
        HashMap<Integer, Node> map = new HashMap<>();
        
        map.put(node.val, new Node(node.val));
        
        fillTheMap(node,map);
        
        // 1 -> [1]
        // 2 -> [2]
        // 3 -> [3]
        // 4 -> [4]
    
        
        // System.out.println(map.get(4));
        addEdges(node, map);   
            
        
        return map.get(1);
        
    }
    
    public void addEdges(Node node, HashMap<Integer, Node> map) {
        
        Node curr = map.get(node.val); // our new node to be updated
        // System.out.println(node.val+" "+curr.val);
        
        vis.add(node.val);
        
        for(Node ele : node.neighbors){
            Node neigh = map.get(ele.val);
            curr.neighbors.add(neigh);
            if(!vis.contains(ele.val))
                addEdges(ele, map);
        }
        
        
        
    }
    
    public void fillTheMap(Node node, HashMap<Integer, Node> map){
        
        map.put(node.val, new Node(node.val));
        
        for(Node ele : node.neighbors){
            if(!map.containsKey(ele.val)){
                fillTheMap(ele, map);
            }
        }
        
        
    }
    
}











