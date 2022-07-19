class Solution {
    public int maxProfit(int[] prices) {
       
        int t[][][] = new int[prices.length][2][3] ;   // Max Transection can be 0 , 1 or 2....that's why 3 states
        for(int a[][] : t){
            for(int ar[] : a){
                Arrays.fill(ar,-1);
            }
        }
        
        
       // return solve(prices , 0, 1, 2,t);
        
         return solveTabulation(prices);
    }
    
    public int solveTabulation(int arr[]){
        int n = arr.length;
//         int t[][][] = new int[n+1][2][3];
        
//         t[n][0][0] = 0;t[n][0][1] = 0;t[n][0][2] = 0;
//         t[n][1][0] = 0;t[n][1][1] = 0;t[n][1][2] = 0;
        
        
//         for(int i = n-1;i>=0;i--){
//             for(int buy = 0;buy<=1;buy++){
//                 for(int maxTran = 1;maxTran < 3;maxTran++){
//                     if(buy > 0){             //max same as tran. is not completed yet
//                         t[i][buy][maxTran] = Math.max(-arr[i] + t[i+1][0][maxTran] , t[i+1][1][maxTran]);
//                     }
//                     else{
//                         t[i][buy][maxTran] =  Math.max(arr[i] + t[i+1][1][maxTran-1] , t[i+1][0][maxTran]);
//                     }
//                 }
                
//             }
//         }
        
//         return t[0][1][2];
        
        
        // SPACE Optimized 1 
        
        int after[][] = new int[2][3];
        int curr[][] = new int[2][3];
        
        for(int i = n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                for(int maxTran = 1;maxTran < 3;maxTran++){
                    
                    if(buy > 0)
                        curr[buy][maxTran] =  Math.max(-arr[i] + after[0][maxTran], after[1][maxTran]);
                    else
                        curr[buy][maxTran] =  Math.max(arr[i] + after[1][maxTran-1], after[0][maxTran]);
                }
            }
            after = curr;
        }
        return after[1][2];
                
    }
    
    public int solve(int arr[],int i, int buy, int maxTran, int t[][][]){
        
        if(i >= arr.length) return 0;
        if(maxTran <= 0) return 0;
        int profit = 0;
        
        if(t[i][buy][maxTran] != -1) return t[i][buy][maxTran];
        
        if(buy > 0){             //max same as tran. is not completed yet
            profit = Math.max(-arr[i] + solve(arr, i+1,0,maxTran,t) , 0 + solve(arr, i+1, 1,maxTran,t));
        }
        else{
            profit =  Math.max(arr[i] + solve(arr, i+1,1,maxTran-1,t) , solve(arr, i+1 , 0, maxTran,t));
        }
        return t[i][buy][maxTran] = profit;
    }
    
}