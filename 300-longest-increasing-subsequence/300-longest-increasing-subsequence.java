class Solution {
    public int lengthOfLIS(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int index = findCorrectPos(list, arr[i]);
            if(index == -1){
                list.add(arr[i]);
            }
            else{
                list.set(index, arr[i]);
            }
        }
        
        return list.size();
        
    }
    
    public int findCorrectPos(List<Integer> list , int target){
        
        int l =  0;
        int r = list.size()-1;
        int ans = -1;
        
        while(l <= r){
            int mid = (l+r)/2;
            if(target <= list.get(mid)){
                ans = mid;
                r = mid-1;
            }
            else l = mid+1;
        }
        return ans;
    }
    
}