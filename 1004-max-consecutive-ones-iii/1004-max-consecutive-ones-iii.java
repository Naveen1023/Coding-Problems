class Solution {
    public int longestOnes(int[] arr, int k) {
        
        int count = 0;
        int i =0;
        int j = 0;
        int res = 0;
        
        while(j < arr.length){
            
            if(arr[j] == 0) count++;
            
            while(i <= j && count > k){
               if(arr[i] == 0) count--;
               i++;
            }
            res = Math.max(res, j-i+1);
            j++;
        }
        return res;
    }
}