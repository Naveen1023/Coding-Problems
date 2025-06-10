class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        
        for(int a[]: dp) Arrays.fill(a, -1);
        
        int lcs = lcs(0,0, word1,word2, dp);
        return (word1.length()-lcs) + (word2.length()-lcs);
    }
    
    private int lcs(int i, int j, String word1, String word2, int dp[][]) {
        
        if(i >= word1.length() || j >= word2.length()) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int lenLCS = 0;
        if(word1.charAt(i) == word2.charAt(j)) {
            lenLCS = 1 + lcs(i+1, j+1, word1, word2,dp);
        }
        else {
            lenLCS = Math.max(lcs(i+1, j, word1, word2,dp), lcs(i,j+1, word1, word2,dp));
        }
        
        return dp[i][j] = lenLCS;
    }
}

/*
lcs is the longest common subseq., order is also preserved, rest everything can be deleted
*/
