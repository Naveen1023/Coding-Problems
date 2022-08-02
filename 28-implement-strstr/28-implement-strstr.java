class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int ans = -1;
        for(int i=0;i<m-n+1;i++){
            
            for(int j=0;j<n;j++){
                if(needle.charAt(j) != haystack.charAt(i+j)) break;
                else if(j == n-1) {
                    ans = i;
                }
            }
            if(ans != -1) return ans;
        }
        return ans;
        
    }
}