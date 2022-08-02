class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        // ...................Plain Serching  O(m*n) Solution ............................
        
//         int ans = -1;
//         for(int i=0;i<m-n+1;i++){
            
//             for(int j=0;j<n;j++){
//                 if(needle.charAt(j) != haystack.charAt(i+j)) break;
//                 else if(j == n-1) {
//                     ans = i;
//                 }
//             }
//             if(ans != -1) return ans;
//         }
//         return ans;
        
        
        // ........................KMP ALgorithm  O(n + m) Solution ............................
        
        /*
        1. compute the LPS array... Longest Prefix Suffix. This will help up to reiterate over the already matched string...
        2. Iterate over haystack, keep incrementing if both matches, otherwise..go to previous lps i.e. lps[j-1]...if at some point j becomes 0 then increment i. 
        3. As soon as j exceeds the length of needle then store i-len(needle) index as answer...
        
        */
        int lps[] = computeLPS(needle);
        int i=0,j=0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;j++;
            }
            else{
                if(j == 0)
                    i++;
                else
                    j = lps[j-1];
            }
            if(j == needle.length()) return i - needle.length();
        }
        return -1;
    }
    // AAAX => [0,1,2,0]
    public int[] computeLPS(String s){   // O(s.length()) 
        int n = s.length();
        int lps[] = new int[n];
        
        int i = 1, prevLPS = 0;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(prevLPS)){
                lps[i] = prevLPS+1;
                prevLPS++;
                i++;
            }
            else{
                if(prevLPS == 0)
                    lps[i++] = 0;
                else 
                    prevLPS = lps[prevLPS-1];
            }
        } 
        return lps;        
    }
}