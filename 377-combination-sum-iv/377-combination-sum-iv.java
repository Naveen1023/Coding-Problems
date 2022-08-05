class Solution {
    Integer dp[];
    public int combinationSum4(int[] arr, int target) {
        dp = new Integer[target+1];
        return solve(target,arr);
        
    }
    public int solve(int target, int arr[]){
        if(target == 0) return 1;
        
        int cnt = 0;
        if(dp[target] != null) return dp[target];
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= target)    
                cnt += solve(target - arr[i] , arr);
        }
        return dp[target] = cnt;
    }
    
}