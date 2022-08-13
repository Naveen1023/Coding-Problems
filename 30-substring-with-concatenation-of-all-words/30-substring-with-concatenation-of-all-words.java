class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
         if(s == null || words.length == 0 || s.length() == 0) return new ArrayList<>();
        
        // this will store the freq. of each words given in words array
        HashMap<String , Integer> map = new HashMap<>();
        
        for(String ele : words)
            map.put(ele, map.getOrDefault(ele, 0)+1);
        
        // every string is of same length
        int eachWordLength = words[0].length();
        int totalWords = words.length;
        
        List<Integer> res = new ArrayList<>();
        
        
        // start iterating on given bigger string to check the occurace.. we want every word 
        // to be included in our current widow substing...exactly given freq number of times...
        
        for(int i=0;i<=s.length() - (totalWords*eachWordLength);i++){
            //check for the first word...which will of of eachWordLength size...
            
            HashMap<String, Integer> seenMap = new HashMap<>();
            
            for(int j =0;j<totalWords;j++){ // every word should be included
                int wordIndex = i + j*eachWordLength;
                String currWord = s.substring(wordIndex, wordIndex+eachWordLength);
                
                //if this is not the word present in given wordslist then no need to proceed
                if(!map.containsKey(currWord)) break;
                
                //also we should be using this word exatly f number of times => f is the freq of this word in word array...
                // for this purpose we have take seenMap HashMap...
                seenMap.put(currWord, seenMap.getOrDefault(currWord,0)+1);
                if(seenMap.get(currWord) > map.get(currWord)) break;
                
                if(j + 1 == totalWords){ // we have seen all the words.. j starts from 0
                    res.add(i);
                }
                
            }
            
        }
        return res;
    }
}