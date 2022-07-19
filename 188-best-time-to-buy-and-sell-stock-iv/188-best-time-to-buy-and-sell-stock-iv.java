class Solution {
    public int maxProfit(int maxT, int[] arr) {
        int n = arr.length;
        maxT = Math.min(maxT, n);  ///// important
        int t[][][] = new int[n+1][2][maxT+1];
        
        for(int ar[][] :t){
            for(int a[] : ar){
                Arrays.fill(a, -1);
            }
        }
       
        // return solve(prices, 0,1,k,t);
        return solve2(0,2*maxT,arr);
        
    }
    
    public int solve2(int in, int tranId, int arr[]){
        // if(i == arr.length) return 0;
        // if(tranId < 0) return 0;
        // if(tranId % 2 == 0){
        //     return Math.max(-arr[i] + solve2(i+1,tranId-1, arr), solve2(i+1,tranId,arr));
        // }
        // else return Math.max(arr[i]+solve2(i+1,tranId-1,arr), solve2(i+1,tranId,arr));
        
// .........................................TABULATION...........................................
        
//         int t[][] = new int[arr.length+1][tranId+1];
        
//         for(int i=arr.length-1;i>=0;i--){
//             for(int id=1;id<=tranId;id++){
//                 if(id % 2 == 0) 
//                     t[i][id] = Math.max(-arr[i]+t[i+1][id-1], t[i+1][id]);
//                 else 
//                     t[i][id] = Math.max(arr[i]+t[i+1][id-1], t[i+1][id]);
//             }
//         }
//         return t[0][tranId];
        
        
        int after[] = new int[tranId+1];
        int curr[]  = new int[tranId+1];
        
        for(int i=arr.length-1;i>=0;i--){
            for(int id=1;id<=tranId;id++){
                if(id % 2 == 0) 
                    curr[id] = Math.max(-arr[i]+after[id-1], after[id]);
                 else 
                    curr[id] = Math.max(arr[i]+after[id-1], after[id]);
            }
            after = curr;
        }
        return after[tranId];
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