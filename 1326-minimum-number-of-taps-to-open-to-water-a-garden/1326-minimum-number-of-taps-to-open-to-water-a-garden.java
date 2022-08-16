class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int arr[] = new int[n+1];
        
        // at every index ,we will store(at leftest point) - the rightest point this tap can reach to...
        // then the problem will reduce to JUMP GAME 2....
        
        for(int i=0;i<ranges.length;i++){
            if(ranges[i] == 0) continue;
            
            int left = Math.max(0, i-ranges[i]);
            
            arr[left] = Math.max(arr[left], i+ranges[i]);
        }
        
        // System.out.println(Arrays.toString(arr));
        
        int l=0,r=0;
        int res = 0;
        
        while(r < arr.length-1){
            int farthest = 0;
            for(int i=l;i<=r;i++){
                farthest = Math.max(farthest, arr[i]);
            }
            if(farthest <= r) return -1;
            l = r+1;
            r = farthest;
            res++;
        }
        return res;
        
        
    }
}