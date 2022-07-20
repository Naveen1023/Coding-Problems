class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int t[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(count, 1);
        Arrays.fill(t, 1);
        
        int maxLen = 0;
        for(int i=0;i<n;i++){
            
            for(int j=0;j<i;j++){
                
                if(arr[j] < arr[i]){
                    if(t[j] + 1 > t[i]){
                        t[i] = t[j] + 1;
                        count[i] = count[j];
                    }
                    else if(t[j] + 1 == t[i]){  // more occurances
                        count[i]+=count[j];
                    }
                
                }
            }
            maxLen = Math.max(maxLen, t[i]);
        }
        
        int res = 0;
        for(int i=0;i<n;i++){
            if(t[i] == maxLen){
                res+=count[i];
            }
        }
        return res;
    }
}