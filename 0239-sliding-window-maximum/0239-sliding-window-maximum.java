class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int res[] = new int[arr.length-k+1];
        int idx = 0;
        PriorityQueue<int []> q = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for(int i=0;i<k-1;i++) {
            q.offer(new int[]{arr[i], i});
        }
        
        int l = 0;
        int r = k-1;
        while(r < arr.length) {
            q.offer(new int[]{arr[r], r});
            int window = r-l+1;
            while(q.peek()[1] < l) { // means older window
                q.poll();
            }
            res[idx++] = q.peek()[0];
            l++;
            r++;
        }
        return res;
    }
}
/**


 */