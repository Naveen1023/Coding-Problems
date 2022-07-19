class Solution {
    public int maxProfit(int[] prices) {
        
//         int t[][][] = new int[prices.length][2][2];
        
//         for(int arr[][] : t){
//             for(int a[] : arr){
//                 Arrays.fill(a, -1);
//             }
//         }
        int t[][] = new int[prices.length+2][2];
        return solve2(0,1,prices,t);
        // return solve(prices, 0,1,0,t);
    }
    
    public int solve2(int in, int bbuy, int arr[], int t[][]){
        // if(i >= arr.length) return 0;
        // if(buy > 0){
        //     return t[i][buy] = Math.max(-arr[i] + solve2(i+1,0,arr,t), solve2(i+1,1,arr,t));
        // }
        // else                                          // skipping for cooldown
        //     return t[i][buy] = Math.max(arr[i] + solve2(i+2,1,arr,t), solve2(i+1,0,arr,t));
        
        
        // .................................TABULATION..........................................
        
        for(int i = arr.length-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                if(buy > 0)
                    t[i][buy] = Math.max(-arr[i] + t[i+1][0], t[i+1][1]);
                else 
                    t[i][buy] = Math.max(arr[i] + t[i+2][1], t[i+1][0]);
            }
        }
        
        return t[0][1];
    }
    
    public int solve(int arr[], int i, int buy, int cooldown,int t[][][]){
        
        if(i >= arr.length) return 0;
        
        if(t[i][buy][cooldown] != -1) return t[i][buy][cooldown];
        
        int profit = 0;
        if(cooldown == 1){
            profit = solve(arr, i+1, buy, 0,t);
        }
        else{
            if(buy == 1){
                int a = -arr[i] + solve(arr, i+1, 0,cooldown,t); // uuy
                int b = solve(arr, i+1,1,cooldown,t);  // not buy
                
                profit = Math.max(a,b);
            }
            else{ // sell , not sell
                int a = arr[i] + solve(arr, i+1, 1,1,t); // sell
                int b = solve(arr, i+1, 0, cooldown,t);  // not sell
                profit = Math.max(a,b);
            }
        }
        return t[i][buy][cooldown] = profit;
    }
}