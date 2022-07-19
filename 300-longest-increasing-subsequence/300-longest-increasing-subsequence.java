class Solution {
    static int res = 0;
    public int lengthOfLIS(int[] arr) {
        
        // int res = 1;
        // int t[] = new int[arr.length];
//         Arrays.fill(t,1);
//         t[0] = 1;
        
//         for(int i=0;i<arr.length;i++){
            
//             for(int j=0;j<i;j++){
                
//                 if(arr[j] < arr[i]){
//                     t[i] = Math.max(t[i], t[j] + 1);
//                     res = Math.max(res, t[i]);
//                 }
                
//             }
//         }
        // return res;   
        
        int t[][] = new int[arr.length+1][arr.length+2];
        for(int a[] : t)
            Arrays.fill(a, -1);
        return solve(0,-1,arr,t);
        
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










