public class Solution {
    int res,start;
    public String longestPalindrome(String s) {
        res = 0;
        start = 0;
       int n = s.length();
       //try to find the center of palindrome....
       for(int i=0;i<n;i++){
           solve(i,i+1,s);
           solve(i,i,s);
       }
       return s.substring(start,start+res);
    }   
    
    public void solve(int i, int j, String s){
        int len = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;j++;
        }   
        if(res < j-i-1){
            res = j-i-1;
            start = i+1;
        }
    }    
}
