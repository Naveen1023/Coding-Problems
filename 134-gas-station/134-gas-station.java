class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0; // amount of fuel we have right now...
        int req = 0;  // required fuel 
        int ans = 0;
        for(int i=0;i<n;i++){
            tank += gas[i] - cost[i];
            if(tank < 0){// this can not be the start station....
                ans = i+1;
                req += tank;  // this is also added as current fuel is less
                tank = 0;  // start fresh for next station
            }
        }
        if(tank >= Math.abs(req)) return ans;
        return -1;
        
    }
}