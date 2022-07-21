class Solution {
    public int minCost(int n, int[] cuts) {
        
        int arr[] = new int[cuts.length+2];
        arr[0] = 0;
        arr[arr.length-1] = n;
        for(int i=0;i<cuts.length;i++)
            arr[i+1] = cuts[i];
        Arrays.sort(arr);
        int t[][] = new int[cuts.length+1][cuts.length+1];
        for(int a[] : t)
            Arrays.fill(a, -1);
        // System.out.println(Arrays.toString(arr));
        return solve(1,cuts.length,arr,t);
    }
    
    public int solve(int i, int j, int arr[],int[][] t){
        if(i > j) return 0;
        
        int mini = Integer.MAX_VALUE;
        
        if(t[i][j] != -1) return t[i][j];
        
        for(int k=i;k<=j;k++){
            int cost = arr[j+1] - arr[i-1] + solve(i,k-1,arr,t) + solve(k+1, j,arr,t) ;
            mini = Math.min(mini, cost);
        }
        return t[i][j] = mini;
        
    }    
}