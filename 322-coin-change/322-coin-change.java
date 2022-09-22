class Solution {
    Integer t[][] ;
    public int coinChange(int[] coins, int target) {
        // if(target == 0) return 0;
        t = new Integer[coins.length][target+1];
        int ans = solve(coins.length-1,coins, target) ;
        
        return (ans == (int)(1e8)) ?  -1 : ans;
                   
    }
    
    public int solve(int i, int arr[] , int target){
        // System.out.println(i+" "+target);
        
        if(target == 0) return 0;
       
        if(i < 0) return (int)1e8;
        
        if(t[i][target] != null) return t[i][target];
        
        if(arr[i] <= target){
            return t[i][target] = Math.min(1+solve(i,arr,target-arr[i]) , solve(i-1,arr,target));
        }
        else
            return t[i][target] = solve(i-1,arr,target);
        
    }
    
}