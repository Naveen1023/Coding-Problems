class Solution {
    class Node implements Comparable<Node>{
        String str;
        int freq;
        
        Node(String s, int f){
            this.str = s;
            this.freq = f;
        }
        
        @Override
        public int compareTo(Node other){
             if(this.freq == other.freq){
                 return this.str.compareTo(other.str);
             }
            return other.freq - this.freq;
        }
        
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        
        for(String str : words){
            map.put(str , map.getOrDefault(str,0)+1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(String str : map.keySet()){
            pq.add(new Node(str , map.get(str)));
        }
        
        
        List<String> res = new ArrayList<>();
        while(k-- > 0){
            res.add(pq.poll().str);
        }
        
        return res;
    }
}