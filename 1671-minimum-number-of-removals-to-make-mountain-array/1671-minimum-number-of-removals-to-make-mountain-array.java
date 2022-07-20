class Solution {
    public int minimumMountainRemovals(int[] arr) {
        int n = arr.length;
        int left[] = new int[n], right[] = new int[n];
        
        for(int i=0;i<arr.length;i++){
            left[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(arr[j] < arr[i] && left[i] < 1 + left[j]){
                    left[i] = 1+left[j];
                }
            }
        }
        // System.out.println(Arrays.toString(left));
        int res = 0;
        for(int i=arr.length-1;i>=0;i--){
            right[i] = 1;
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[i] && right[i] < 1 + right[j]){
                    right[i] = 1 + right[j];
                }
            }
            if(left[i] == 1 || right[i] == 1) continue;
            res = Math.max(res, left[i] + right[i]-1);
        }
        // System.out.println(Arrays.toString(right));
       return n - res;
    }
}