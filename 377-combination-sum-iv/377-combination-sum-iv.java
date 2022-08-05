class Solution {
    Integer dp[][];
    public int combinationSum4(int[] arr, int target) {
        dp = new Integer[arr.length][target+1];
        return solve(0,0,target,arr);
        
    }
    public int solve(int index,int sum, int target, int arr[]){
        // System.out.println(index+" "+sum);
        if(sum == target) return 1;
        else if(index >= arr.length || sum > target) return 0;
        
        if(dp[index][sum] != null) return dp[index][sum];
        
        int count = 0;
        for(int i=0;i<arr.length;i++){
            
            sum += arr[i];
            count += solve(i, sum, target,arr);
            sum-=arr[i];
        }
        
        return dp[index][sum] = count;
    }
    
}