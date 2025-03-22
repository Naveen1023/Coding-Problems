class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = -1;
        int prevGas = 0;
        int tank = 0;
        int i = 0;

        while (i < gas.length) {
            int j = i;
            res = i;
            while (j < gas.length) {
                prevGas += gas[j] - cost[j];
                tank += gas[j] - cost[j];
                if (tank < 0) {
                    tank = 0;
                    res = -1;
                    break;
                }
                j++;
            }
            i = j+1;
        }
        return (prevGas >= 0) ? res : -1;
    }
}