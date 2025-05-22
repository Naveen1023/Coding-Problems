class Solution {
    public int reversePairs(int[] arr) {
        
        int ans = mergeSort(0,arr.length-1,arr);
        System.out.println(Arrays.toString(arr));
        return ans;
    }
    
    public int mergeSort(int l, int r, int a[]){
        
        
        int mid = (l+r)/2;
        int res = 0;
        if(l < r){
            res = res + mergeSort(l, mid,a);
            res = res + mergeSort(mid+1,r,a);
            res = res + merge(l,mid,r,a);
        }
        return res;
    }
    
    public int merge(int l, int m, int r, int a[]){
        int left[] = new int[(m-l+1)];
        int right[] = new int[(r-m)];
        int k = 0;
        int res = 0;
        
        for(int i=l;i<=m;i++) left[k++] = a[i]; 
        k=0;
        for(int i=m+1;i<=r;i++)right[k++] = a[i];
        int count = 0;
        // find the COUNT
        int j = 0;
        for(int i=0;i<left.length;i++){
            while(j < right.length && left[i] > (2l * right[j])) j++;
            count += j;
        }
        
        int i=0;
        j=0;
        k = l;
        
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]) a[k++] = left[i++];
            else if(left[i] > right[j]) a[k++] = right[j++];
        }
        
        while(i < left.length) a[k++] = left[i++];
        while(j < right.length) a[k++] = right[j++];
        
        return count;
    }
    
}




