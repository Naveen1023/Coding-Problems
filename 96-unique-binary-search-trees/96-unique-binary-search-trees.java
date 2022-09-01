class Solution {
    Integer t[];
    public int numTrees(int n) {
        
        t = new Integer[n+1];
        
        t[0] = 1;
        t[1] = 1;
        
        return solve(n);
        
        
    }
    
    public int solve(int n){
        
        if(n == 0 || n == 1) return 1;
        
        if(t[n] != null) return t[n];
        
        int total = 0;
        for(int i=1;i<=n;i++){
            int leftSide = solve(i-1);
            int rightSide = solve(n-i);
            
            total += (leftSide * rightSide);
            
        }
        
        return t[n] = total;
    }
    
}