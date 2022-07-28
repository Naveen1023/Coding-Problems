class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int f[] = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            f[ch - 'a']++;
            ch = t.charAt(i);
            f[ch - 'a']--;
        }
        for(int ele : f){
            if(ele != 0) return false;
        }
        return true;
    }
}