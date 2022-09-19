class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        // domains , freq of domains
        HashMap<String , Integer> map = new HashMap<>();
        
        for(String str : cpdomains){
            int i = 0 ,n = str.length();
            //find space
            while(i < n && str.charAt(i) != ' ') i++;  // 900 google.mail.com
            int f = Integer.parseInt(str.substring(0,i));  // f = 900
            i++;
            //find the first domain
            String first = str.substring(i,n);
            map.put(first, map.getOrDefault(first,0) + f);
            
            // find second domain...
            while(i < n && str.charAt(i) != '.') i++; 
            i++;
            String second = str.substring(i,n);
            map.put(second, map.getOrDefault(second,0) + f);
            
            // find the third domain if it exists
            while(i < n && str.charAt(i) != '.') i++; 
            i++;
            if(i < n){
                String third = str.substring(i,n);
                if(third.length() > 0)
                    map.put(third, map.getOrDefault(third,0) + f);

            }
             
        }
        
        List<String> res = new ArrayList<>();
        
        for(String key : map.keySet()){
            String out = Integer.toString(map.get(key))+" ";
            out += key;
            
            res.add(out);
        }
        
        return res;
            
    }
}