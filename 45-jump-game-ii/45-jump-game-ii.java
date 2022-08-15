class Solution {
    Integer t[];
    public int jump(int[] arr) {
//         t = new Integer[arr.length];
//         // return solve(0,arr);
        
//         t[arr.length-1] = 0;
        
//         for(int i=arr.length-2;i>=0;i--){
//             int ans = 1000000;
//             int len = arr[i];
//             for(int jump=1;jump<=len;jump++){
//                 if((i + jump) < arr.length)
//                     ans = Math.min(ans , 1+t[i+jump]);
//             }
//             t[i] = ans;
//         }
//         return t[0];
        
        
        
        
        // ................Optimal BFS Solution..............................
        
        int l = 0,r=0;
        int steps = 0;
        while(r < arr.length-1){
            int farthest = 0;
            for(int i=l;i<=r;i++){
                farthest = Math.max(farthest, i+arr[i]);
            }
            // go to next level now
            l = r+1;
            r = farthest;
            steps++;
        }
        return steps;
        
        
        
    }
    public int solve(int i, int arr[]){
        
        if(i >= arr.length) return (int)1e5;
        if(i == arr.length-1) return 0;
        
        if(t[i] != null) return t[i];
        
        int ans = 1000000;
        int len = arr[i];
        for(int jump=1;jump<=len;jump++){
            ans = Math.min(ans , 1+solve(i+jump,arr));
        }
        return t[i] = ans;
    }
    
}