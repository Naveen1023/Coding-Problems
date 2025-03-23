class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int l = 0, r=arr.length-1;

        while(l <= r) {
            int mid = l + (r-l)/2;
            
            if((mid == 0 && arr[mid] <= arr[r]) || (mid > 0 && arr[mid-1] > arr[mid])) {
                return arr[mid];
            }
            else if(arr[mid] > arr[r]) {
                l = mid+1;
            }
            else r = mid-1;
        }

        return -1;
    }
}

/**
1. Need to find out inflection point. 
    rotated array pattern : (increasing seq 1) -> inflection -> (increasing seq 2)
    All the elements in seq1 are greater than all the elements of seq2

    => if mid is not the answer => how to shrink down ? 
        a. if a[mid] > arr[right] => we are seq1 => move right side
        b. else move left.

 */