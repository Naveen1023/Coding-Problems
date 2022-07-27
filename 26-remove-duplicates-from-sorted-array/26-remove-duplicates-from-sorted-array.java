class Solution {
    public int removeDuplicates(int[] arr) {
        
        int index = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == arr[i-1]) continue;
            arr[++index] = arr[i];            
        }
        return index+1;
    }
}