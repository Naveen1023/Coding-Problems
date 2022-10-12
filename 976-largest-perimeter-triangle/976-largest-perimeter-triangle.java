class Solution {
    public int largestPerimeter(int[] arr) {
        
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        
        while(l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;r--;
        }
    
        int res = 0;
        
        for(int i=0;i<arr.length-2;i++){
            if(arr[i] < arr[i+1] + arr[i+2]){
                res = Math.max(res, arr[i] + arr[i+1] + arr[i+2]);
            }
        }
        
        return res;
        
    }
}