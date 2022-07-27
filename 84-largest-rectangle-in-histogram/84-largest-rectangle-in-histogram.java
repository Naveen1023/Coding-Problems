class Solution {
    public int largestRectangleArea(int[] heights) {
        
       // rectangle at one index can expand to left and right side till increasing histograms are coming.. so we need to find the very first left side smaller and right side smaller element index as till that point histogram will expland...
        int res = 0;
        int leftSmaller[] = new int[heights.length];
        int rightSmaller[] = new int[heights.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            
            if(st.isEmpty()) leftSmaller[i] = -1;
            else leftSmaller[i] = st.peek();
            st.push(i);
            
        }
        
        // System.out.println(Arrays.toString(leftSmaller));
        
        st.clear();
        for(int i=heights.length - 1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            
            if(st.isEmpty()) rightSmaller[i] = heights.length;
            else rightSmaller[i] = st.peek();
            st.push(i);
            res = Math.max(res, (rightSmaller[i] - leftSmaller[i] - 1 )* heights[i]);
        } 
        // 0   1   2   3   4   5
        // 2   1   5   6   2   3
// ls =   -1  -1   1   2   1   4
// rs =    1   6   4   4   6   6
        
        // System.out.println(Arrays.toString(rightSmaller));
        
        return res;
    }
}