class Solution {
    public int kthSmallest(int[][] arr, int k) {
         /// min heap over values
        int n = arr.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        
        for(int i=0;i<arr.length;i++){
            pq.offer(new int[]{arr[i][0],i,0});
        }
        int res = 0;
        while(k-- > 1){
            int curr[] = pq.poll();
            int row  = curr[1];
            int col = curr[2];
            
            if(col + 1 < n){
                pq.offer(new int[]{arr[row][col+1], row,col+1});
            }
        }
        return pq.poll()[0];
        
    }
}