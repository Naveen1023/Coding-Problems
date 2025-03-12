class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        for (int a : dp)
            Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    public int solve(int n, int dp[]) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }
}
/**
 * f(3) -> f(1), f(2)
 * f(0) -> 0
 * f(1) -> 1
 * f(2) -> 2
 * 
 */