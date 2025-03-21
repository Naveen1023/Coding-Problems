class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean dp[][] = new Boolean[s1.length()+1][s2.length()+1];

        for(Boolean a[] : dp) 
            Arrays.fill(a, null);

        return solve(0, 0, 0, s1, s2, s3,dp);
    }

    public boolean solve(int i, int j, int k, String s1, String s2, String s3, Boolean dp[][]) {

        if(k == s3.length() && i == s1.length() && j == s2.length()) return true;

        if(dp[i][j] != null) return dp[i][j];

        char ch = '0';
        if(k < s3.length()) ch = s3.charAt(k);

        if (i < s1.length() && j < s2.length() && s1.charAt(i) == ch && s2.charAt(j) == ch) {
            return dp[i][j] = solve(i + 1, j, k + 1, s1, s2, s3,dp) || solve(i, j + 1, k + 1, s1, s2, s3,dp);
        } else if (i < s1.length() && s1.charAt(i) == ch) {
            return dp[i][j] = solve(i + 1, j, k + 1, s1, s2, s3,dp);
        } else if (j < s2.length() && s2.charAt(j) == ch) {
            return dp[i][j] = solve(i, j + 1, k + 1, s1, s2, s3,dp);
        }
        return false;
    }
}