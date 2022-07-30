class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int f[] = new int[26];
        for(String s : words2){
            int temp[] = new int[26];
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                temp[ch-'a']++;
                if(temp[ch-'a'] > f[ch-'a']) f[ch-'a'] = temp[ch-'a'];
            }
            
        }
        
        
        for(String w : words1){
            // check for evry word if it has all the freq greater than/equals the one stored in F array         
            int temp[] = new int[26];
            for(int i=0;i<w.length();i++){
                char ch = w.charAt(i);
                temp[ch-'a']++;            
            }
            boolean flag = true;
            for(int i=0;i<26;i++){
                if(temp[i] < f[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) list.add(w);
        }
        
        return list;
    }
}