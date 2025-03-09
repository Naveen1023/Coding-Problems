class Solution {
    List<List<String>> res;
    public List<List<String>> groupAnagrams(String[] arr) {
        res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            char temp[] = arr[i].toCharArray();
            Arrays.sort(temp);
            String curr = Arrays.toString(temp);

            if(!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(arr[i]);
        }

        for(List<String> temp : map.values()) {
            res.add(temp);
        }

        return res;
    }
}