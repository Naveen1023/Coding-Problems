class Solution {
    public int search(int[] arr, int target) {
        if(arr.length == 1) return (arr[0] == target) ? 0 : -1;
        int lastIndex = findLastIndex(arr);
        // System.out.println(lastIndex);
        
        int a = findElement(arr,target,0,lastIndex);
        if(a != -1) return a;
        else return findElement(arr,target,lastIndex+1,arr.length-1);
        
    }
    
    public int findElement(int arr[], int target, int l, int r){
        if(l > r) return -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(arr[mid] == target) return mid;
            else if(target < arr[mid]) r = mid-1;
            else l = mid+1;
        }
        
        return -1;        
    }
    
    public int findLastIndex(int arr[]){
        int l = 0;
        int r = arr.length-1;
        
        while(l<=r){
            int mid = l + (r-l)/2;
            
            if(mid+1 < arr.length && arr[mid] > arr[mid+1]) return mid;
            else{
                if(arr[mid] >= arr[l]) { // left side is sorted, breakpoint is not there
                    l = mid+1;
                }
                else r = mid-1;
                
            }
        }
        return -1;
    }
    
}