class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int t[][][] = new int[n+1][2][k+1];
        
        for(int ar[][] :t){
            for(int a[] : ar){
                Arrays.fill(a, -1);
            }
        }
        
        
        return solve(prices, 0,1,k,t);
    }
    public int solve(int arr[], int i, int buy, int k, int t[][][]){
        
        if(i == arr.length) return 0;
        if(k == 0) return 0;
        
        if(t[i][buy][k] != -1) return t[i][buy][k]; 
        
        int profit = 0;
        if(buy > 0){ // we can buy or not
            profit = Math.max(-arr[i] + solve(arr, i+1,0,k,t) , 0 + solve(arr,i+1,1,k,t));
        }
        else{ // we can sell on current day or not
            profit = Math.max(arr[i] + solve(arr, i+1,1,k-1,t) , solve(arr, i+1,0,k,t));
        }
        
        return t[i][buy][k] = profit;
    }
    
}