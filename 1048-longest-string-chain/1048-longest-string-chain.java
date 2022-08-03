class Solution {
    public int longestStrChain(String[] arr) {
        Arrays.sort(arr, (s1,s2)->s1.length()-s2.length());
        int currLength[] = new int[arr.length];
        Arrays.fill(currLength, 1);
        // "a","b","ba","bca","bda","bdca" 
        int res = 1;
        //check for every word, 
        for(int i=0;i<arr.length;i++){
            int len = 0;
            for(int j=0;j<i;j++){ 
                if(arr[j].length() == arr[i].length()-1){
                    if(isPredecessor(arr[j],arr[i])){
                        currLength[i] = Math.max(currLength[i], currLength[j]+1);
                        res = Math.max(res, currLength[i]);
                    }
                }
            }
            
            
        }
        return res;
    }
    
    public boolean isPredecessor(String a, String b){
        int i=0;
        int j =0;
        boolean skipped = false;
        while(i < a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else{
                if(skipped) return false;
                j++;skipped = true;
            }
        }
        return true;
    }
    
}