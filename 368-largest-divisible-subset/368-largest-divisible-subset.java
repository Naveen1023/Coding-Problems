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
    }
    
}