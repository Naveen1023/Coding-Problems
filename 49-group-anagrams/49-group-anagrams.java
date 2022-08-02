class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<Integer>> map = new HashMap<>();
        
        
        for(int i=0;i<strs.length;i++){
            char arr[] = strs[i].toCharArray();
            Arrays.sort(arr);
            String temp = String.valueOf(arr);
            if(!map.containsKey(temp)){
                map.put(temp,new ArrayList<>());
            }
            map.get(temp).add(i);
        }        
        
        List<List<String>> res = new ArrayList<>();
        
        for(List<Integer> l : map.values()){
            List<String> temp = new ArrayList<>();
            for(int i : l) temp.add(strs[i]);
            res.add(temp);
        }
        return res;
    }
}