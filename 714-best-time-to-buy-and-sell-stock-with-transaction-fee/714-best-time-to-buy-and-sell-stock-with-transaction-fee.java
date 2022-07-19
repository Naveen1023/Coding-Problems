class Solution {
    public int maxProfit(int[] arr, int fee) {
        
        int t[][] = new int[arr.length][2];
        
        for(int a[] : t)
            Arrays.fill(a, -1);
        return solveTabulation(fee,arr);
        // return solve(arr, 0, 1,fee,t);
    }
    
    public int solveTabulation(int fee ,int arr[]){
        
        int t[][] = new int[arr.length+1][2];
        
        for(int i=arr.length-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                if(buy > 0){
                    t[i][buy] = Math.max(-arr[i] + t[i+1][0], t[i+1][1]);
                }       
                else
                    t[i][buy] = Math.max(arr[i] - fee + t[i+1][1], t[i+1][0]);
            }
        }
        return t[0][1];
    }    
    
    public int solve(int arr[], int i, int buy, int fee, int t[][]){
        
        if(i >= arr.length) return 0;
        
        int profit = 0;
        
        if(t[i][buy] != -1) return t[i][buy];
        
        if(buy == 1){
            
            int a = -arr[i] + solve(arr, i+1,0,fee, t);
            int b  = solve(arr, i+1, 1, fee ,t);
            profit = Math.max(a,b);
        }
        else{
            int a  = arr[i] - fee + solve(arr, i+1,1,fee, t);
            int b = solve(arr, i+1 ,0,fee,t);
            profit = Math.max(a,b);
        }
        return t[i][buy] = profit;
    }
    
}