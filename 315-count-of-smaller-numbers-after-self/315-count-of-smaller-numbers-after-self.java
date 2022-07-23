class Solution {
    public List<Integer> countSmaller(int[] arr) {
        
        
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int ele : arr) list.add(ele);
        
        Collections.sort(list);
        
        for(int i=0;i<arr.length;i++){
            int ans = binarySearch(list, arr[i]);
            list.remove(ans);
            res.add(ans);
        }
        return res;        
    }
    
    public int binarySearch(List<Integer> list, int target){
        int l = 0;
        int r = list.size()-1;
        int ans = list.size();
        while(l <= r){
            int mid = l + (r-l)/2;
            if(target == list.get(mid)){
                ans = mid;
            }
            if(target <= list.get(mid)){
                r = mid -1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
    
}