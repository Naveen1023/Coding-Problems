class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(0, s, dp);
    }

    public int solve(int i, String s, int dp[]) {

        if(i == s.length()) return 1;
        if(i > s.length()) return 0;

        if(dp[i] != -1) return dp[i];

        int chooseOneDigits = Integer.parseInt(String.valueOf(s.charAt(i)));
        int chooseTwoDigits = (i < s.length()-1) ? Integer.parseInt(s.substring(i,i+2)) : 99;
        int ways = 0;

        if(chooseOneDigits > 0 && chooseOneDigits <= 9) {
            ways += solve(i+1, s,dp);
        }

        if(chooseTwoDigits > 9 && chooseTwoDigits <= 26) {
            ways += solve(i+2, s, dp);
        }

        return dp[i] = ways;
    }
}

/**
226
2, f(1) 
    2, f(2)
    +
    26, f(3)
+ 
22, f(2)
    6, f(3)
    .. , f(4)
    ...need to handle
 */