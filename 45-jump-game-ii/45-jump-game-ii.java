class Solution {
    Integer t[];
    public int jump(int[] nums) {
        t = new Integer[nums.length];
        return solve(0,nums);
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