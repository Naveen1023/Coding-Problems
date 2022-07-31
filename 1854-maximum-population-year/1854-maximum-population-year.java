class Solution {
    public int maximumPopulation(int[][] logs) {
        int n = 2050-1950+1;
        int arr[] = new int[n];   ;
        
        
//         for(int a[] : logs){
//             for(int i=a[0];i<a[1];i++){
//                 arr[i-1950]++;
//             }
//         }
//         int res = 0;
//         for(int i=0;i<arr.length;i++){
//             if(arr[res] < arr[i]) res = i;
//         }
        
//         // System.out.println(Arrays.toString(arr));
//         return res+1950;
        
        // ............................LINE SWEEP...................................
        
//          we can mark the start and end for current interval...then iterate over the array to count the maximum freq.
        
        for(int a[] : logs){
            arr[a[0]-1950]++;   // start marked  with +1
            arr[a[1]-1950]--;  // endin marked with -1
        } 
        int res = 0;
        for(int i=1;i<arr.length;i++){
            arr[i] = arr[i] + arr[i-1];
            if(arr[i] > arr[res]) res = i;
        }
        return res + 1950;
    }
}