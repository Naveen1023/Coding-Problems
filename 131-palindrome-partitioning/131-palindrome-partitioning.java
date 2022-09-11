class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        
        res = new ArrayList<>();
        
        solve(s, new ArrayList<>());
        
        return res;
    }
    
    public void solve(String s, List<String> list){
        
        if(s == null || s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<s.length();i++){
            String temp = s.substring(0,i+1);
            if(isPalindrome(temp)){
                list.add(temp);
                solve(s.substring(i+1), list);
                list.remove(list.size()-1);
            }
        }
    }
    
    
    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
    
}