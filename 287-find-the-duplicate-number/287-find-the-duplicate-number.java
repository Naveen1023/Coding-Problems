class Solution {
    public int findDuplicate(int[] nums) {
        
        int l = 1;
        int r = nums.length-1;
        
        while(l <= r){
            int mid = l + (r-l)/2;
            
            //check if mid is the answer....
            int cnt = 0;
            for(int ele : nums){
                if(ele <= mid) cnt++;
            }
            if(cnt <= mid) { 
                l = mid+1;
            }
            else{
                r = mid-1;
            }
            
        }
        return l;
        
        
    }
}