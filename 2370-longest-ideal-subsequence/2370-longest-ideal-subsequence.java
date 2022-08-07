class Solution {
    Integer dp[][];
    public int longestIdealString(String s, int k) {
        dp = new Integer[s.length()][100];
        int arr[] = new int[s.length()];
        int kk = 0;
        for(int i=0;i<s.length();i++){
            char ele = s.charAt(i);
            arr[kk++] = ele - 'a';
        }
        
        return solve(0,-1,arr,k);
    }
    
    public int solve(int index, int prev, int arr[],int k){
        if(index == arr.length) return 0;
        int ans = 0;
        int curr = arr[index];
        if(dp[index][prev+1] != null) return dp[index][prev+1];
        int temp = prev;
        if(prev == -1) temp = arr[index];
        
        if(Math.abs(temp - arr[index]) <= k){
            return dp[index][prev+1] = Math.max(solve(index+1, prev, arr,k), 1+ solve(index+1, arr[index], arr,k));
        }        
        return dp[index][prev+1] = solve(index+1, prev,arr,k);
    }
    
}