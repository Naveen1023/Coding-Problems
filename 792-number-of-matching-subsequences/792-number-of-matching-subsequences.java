class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int res = 0;
        
        for(String word : words){
            
            if(map.containsKey(word)) res+= map.get(word);
            else{
                int i=0,j=0;
                while(i < s.length() && j < word.length()){                
                    if(s.charAt(i) == word.charAt(j)){
                        i++;j++;
                    }
                    else i++;
                
                }
                if(j < word.length()) map.put(word,0);
                else map.put(word,1);
                res+=map.get(word);
            }
            
        }
        return res;
    }
}