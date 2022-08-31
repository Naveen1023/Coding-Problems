class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int l=Integer.MIN_VALUE, r=0;
        
        for(int w : weights) {
            l = Math.max(l , w);
            r += w;
        }
        
        int ans = -1;
        
        while(l <= r){
            
            int mid = l + (r-l)/2;
            int count = isValid(mid,weights);
            // System.out.println(count)   ;
            if(count <= days){
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
            
        }
        return ans;
        
    }
    
    public int isValid(int target, int arr[]){
        
        // int total = 0;
        // int count = 1;
        // for(int w : arr) {
        //     total+=w;
        //     if(total > target) {
        //         count++;
        //         total = w;
        //     }
        // }
        // return count;
        
        int cnt = 1;
        int currW = 0;
        
        for(int i=0;i<arr.length;i++){
            if((currW + arr[i] ) <= target){
                currW += arr[i];
            }      
            else{
                currW = arr[i];
                cnt++;
            }
        }        
        return cnt;
    }
    
}