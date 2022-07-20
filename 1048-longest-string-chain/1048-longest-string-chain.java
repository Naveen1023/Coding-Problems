class Solution {
    public int longestStrChain(String[] arr) {
     
        int t[] = new int[arr.length];
        int res = 1;
        Arrays.fill(t, 1);
        Arrays.sort(arr, (s1,s2)->s1.length() - s2.length());
        
        for(int i=0;i<arr.length;i++){
            
            for(int j=0;j<i;j++){
                //  only check is len is 1 less than curr length...
                if(arr[j].length() == arr[i].length()-1){
                    
                    if(isPredecessor(arr[j], arr[i]) == true){
                        t[i] = Math.max(t[i], t[j] + 1);
                        res = Math.max(res, t[i]);
                    }
                    
                }
            }
        }
        
        return res;
    }
    
    public boolean isPredecessor(String s1, String s2){

           if(s2.length() - s1.length() != 1) return false;
        
           int i = s1.length()-1, j = s2.length()-1;
        boolean skipped = false;
        while(i >= 0 && j >= 0){
            if(s1.charAt(i) == s2.charAt(j)){
                i--;j--;                    
            }
            else if(!skipped){
                skipped = true;
                j--;
            }
            else return false;
        }
        return true;
//         int i,j;
//         i = j = 0;
//         while(i < s1.length() && j < s2.length()){
            
//             if(s1.charAt(i) == s2.charAt(j)){
//                 i++;j++;
//             }
//             else{
//                 j++;
//             }
//         }
//           // abc    kkbc
//         return !(i < s1.length());
        
    }    

}






