class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        
        ArrayList<int []> list=  new ArrayList<>();
        
        int start = arr[0][0];
        int end = arr[0][1];
        for(int i=0;i<arr.length;i++){
            
            start = arr[i][0];
            end = arr[i][1];
            int j = i+1;
            while(j < arr.length && arr[j][0] <= end){
                end = Math.max(end, arr[j][1]);
                j++;
            }
            i = j-1;
            list.add(new int[]{start,end});
        }
        
        int res[][] = new int[list.size()][2];
        int k =0;
        for(int a[] : list){
            res[k++] = a;
        }
        return res;
    }
}