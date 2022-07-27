class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        
//          O(1) solution
        // we need to consider only minimum of left and right... 
        
        int lMax = arr[0], rMax=  arr[n-1];
        int l=0,r= n-1;
        int res = 0;
        while(l <= r){
            
            if(lMax < rMax){
                int currWater = lMax - arr[l];
                lMax = Math.max(lMax, arr[l]);
                l++;
                currWater = (currWater < 0) ? 0 : currWater;
                res+=currWater;
            }
            else{
                int currWater = rMax - arr[r];
                rMax=  Math.max(rMax, arr[r]);
                r--;
                currWater = (currWater < 0) ? 0 : currWater;
                res+=currWater;
            }
        }
        return res;
        
        
        
        // O(n)  solution 
//         int left[] = new int[n];
//         // int right[] = new int[n];
//         left[0] = arr[0];
//         for(int i=1;i<n;i++){
//             left[i] = Math.max(left[i-1] , arr[i]);
//         }
//         int right = arr[n-1];
        
//         int res = 0;
//         for(int i=n-2;i>=0;i--){
//             int currWater = Math.min(left[i],right) - arr[i];
//             currWater = (currWater < 0) ? 0 : currWater;
//             res += currWater;
//             right = Math.max(right, arr[i]);
//         }
//         return res;
        
    }
}