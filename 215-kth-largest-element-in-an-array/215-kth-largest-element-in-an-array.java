class Solution {
    public int findKthLargest(int[] arr, int k) {
        
        // kth largest element...
        
        // sort => nlogn
        // max Heap, pop k-1 time then return the top element from heap.. same compl.
        //  5,5,4,4,2  => 3rd largest => 4
        
        
        // kth min Heap , where largest element is at top, below root, every element is greater...
        
        // top k greater elements in heap(MIN) .. root will bethe answer....
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int ele : arr){
            if(pq.size() < k){
                pq.offer(ele);
            }
            else{
                if(ele > pq.peek()){
                    pq.poll();
                    pq.offer(ele);
                }
            }
        }
        
        return pq.peek();
        
    }
}