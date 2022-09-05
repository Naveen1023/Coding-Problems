class Solution {
    public int intersectionSizeTwo(int[][] arr) {
        int res = 0;
        
        Arrays.sort(arr, (a,b)->(a[1]!=b[1]) ? (a[1]-b[1]):(b[0]-a[0]));
        
        int h1 = arr[0][1];
        int h2 = arr[0][1] - 1;
        res = 2;
        
        for(int i=1;i<arr.length;i++){
            
            int start = arr[i][0];
            int end = arr[i][1];
            
            if(start > h1){
                res+=2;
                h1 = end;
                h2 = end-1;
            }
            else if(start > h2 && start <= h1){
                res+=1;
                h2 = h1;
                h1 = end;
            }
        }    
        return res;
    }
}