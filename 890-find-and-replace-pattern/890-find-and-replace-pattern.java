class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        HashMap<Character, Character> map  = new HashMap<>();
        List<String> list= new ArrayList<>();
        
        for(String w : words)
        {
            int i =0, j=0;
            boolean match = true;
            int f[] = new int[26];
            while(i < w.length()  && j < pattern.length()){
                char ch1 = w.charAt(i);
                char ch2 = pattern.charAt(j);
                if(!map.containsKey(ch2)) {
                    // System.out.println(ch1+" "+f[ch1-'a']);
                    if(f[ch1 - 'a'] > 0) { // already mapped by certain other character
                        match = false;
                        break;
                    }
                    map.put(ch2,ch1);
                    f[ch1 - 'a']++;
                }
                if(map.get(ch2) != ch1) {
                    match = false;
                    break;
                }
                i++;j++;
            }
            if(match) list.add(w);
            map.clear();
        }
        
        return list;
    }
}