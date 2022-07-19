
            // Recursive Version : Good to know = > if this problem is modified to bigger complex problem then converting it to DP solution would be easy... 
class Solution {
    public int maxProfit(int[] prices) {
        return solve(0,Integer.MAX_VALUE, prices) ;
    }
    
    public int solve(int index, int prev, int arr[]){
        if(index == arr.length) return 0;
        int currProfit = 0;
        currProfit = arr[index] - prev;
        int temp = 0;
        if(arr[index] < prev){
            temp = solve(index+1, arr[index], arr);
        }
        else temp = solve(index+1, prev, arr);
        
        return Math.max(currProfit, temp);
    }    
}