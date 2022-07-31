class Solution {
    public int maximumPopulation(int[][] logs) {
        int n = 2050-1950+1;
        int arr[] = new int[n];   ;
        
        
        for(int a[] : logs){
            for(int i=a[0];i<a[1];i++){
                arr[i-1950]++;
            }
        }
        int res = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[res] < arr[i]) res = i;
        }
        
        // System.out.println(Arrays.toString(arr));
        return res+1950;
    }
}