class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int res = 0;
        int n = colors.length();
        
        
        for(int i=0;i<n;i++){
            int sameColorSum = neededTime[i];
            int maxColor = neededTime[i];    
            int j = i+1;
            while(j < n && colors.charAt(j) == colors.charAt(i)){
                sameColorSum += neededTime[j];
                maxColor = Math.max(maxColor, neededTime[j]);
                j++;
            }
            // System.out.println(maxColor);
            res += (sameColorSum - maxColor);
            i = j-1;
        }
        
        return res;
        
    }
}