class Solution {
    static int res = 0;
    public int lengthOfLIS(int[] arr) {
          
        // int t[][] = new int[arr.length+1][arr.length+1];
        // for(int a[] : t)
        //     Arrays.fill(a, -1);
        // return solve(0,-1,arr,t);
        
        
        // ...........................TABULATION........................................
        
        // for(int i=arr.length-1;i>=0;i--){
        //     for(int prev = i-1;prev>=-1;prev--){
        //         if(prev == -1 || arr[i] > arr[prev]){
        //             t[i][prev+1] = Math.max(1 + t[i+1][i+1], t[i+1][prev+1]);
        //         }
        //         else 
        //             t[i][prev+1] = t[i+1][prev+1];
        //     }
        // }
        // return t[0][0];
        
        // ...............................OPTIMAL SOLUTION.................................
        
        int t[] = new int[arr.length];
        int res = 1;
        //at every index, store the longest increasing subseq till that index........
        Arrays.fill(t, 1);
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j] < arr[i])
                    t[i] = Math.max(t[i], 1+t[j]);
            }
            res = Math.max(res, t[i]);
        }
        return res;
    }
    	
	public static int solve(int i, int prev,int arr[], int t[][]){
	    if(i == arr.length) return 0;
        if(t[i][prev+1] != -1) return t[i][prev+1];
        if(prev == -1 || arr[i] > arr[prev]){
            return t[i][prev+1] = Math.max(1 + solve(i+1,i,arr,t), solve(i+1,prev,arr,t));
        }
        else return t[i][prev+1] = solve(i+1,prev,arr,t);
    }  
}










