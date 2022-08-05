class Solution {
    Integer dp[];
    public int combinationSum4(int[] arr, int target) {
        dp = new Integer[target+1];
        // return solve(target,arr);
        
        // target : target to 0 
        dp[0] = 1;
        for(int sum = 1;sum<=target;sum++){
            int cnt = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i] <= sum)    
                    cnt += dp[sum - arr[i]];
            }
            dp[sum] = cnt;
        }
        
        return dp[target];
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