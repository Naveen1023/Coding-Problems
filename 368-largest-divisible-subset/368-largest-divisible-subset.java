class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
     
        List<Integer> list = new ArrayList<>();
        int count[] = new int[arr.length];
        int hash[] = new int[arr.length];
        Arrays.sort(arr);
        int max_index = 0;
        for(int i=0;i<arr.length;i++){
            count[i] = 1;
            hash[i] = i;
            for(int j=i-1;j>=0;j--){
                if(arr[i] % arr[j] == 0 && count[i] < count[j]+1){ // no need to check arr[j]%arr[i]== 0 as sorted.. arr[j] will be smaller that arr[i]
                    hash[i] = j;
                    count[i] = count[j]+1;
                    if(count[i] > count[max_index]) max_index = i;
                }
            }   
        }        
        int temp = max_index;
        
        while(hash[temp] != temp){
            list.add(arr[temp]);
            temp = hash[temp];
        }
        list.add(arr[temp]);
        // Collections.reverse(list);
        return list;
//         Arrays.sort(arr);   /// if we dont, [6,2,8] will be right, but it is not....
//         int count[] = new int[arr.length]; // for counting the current length of subet at that loc
//         int sub[] = new int[arr.length]; // instead of maintaing a list at every index, we'll maintian indices in smart way
        
//         int index = -1;
//         int max = Integer.MIN_VALUE;
//         for(int i=0;i<arr.length;i++){
            
//             count[i] = 1;
//             sub[i] = -1;
            
//             for(int j=i-1;j>=0;j--){
                
//                 if(arr[i] % arr[j] == 0){
//                     if(count[j] + 1 > count[i]){
//                         count[i] = count[j] + 1;
//                         sub[i] = j;              ///// means this sub came from after jth index,
//                     }
//                 }                
//             }
//             if(count[i] > max){
//                     max = count[i];
//                     index = i;  // maintaing at which inddex is the max subset
//             }
            
//         }
        
//         while(index!=-1){
//             res.add(arr[index]);  // go to that element
//             index = sub[index];  // go to it's previous from where it came from and access then so on...
//         }
        
//         return res;
    }
    
}