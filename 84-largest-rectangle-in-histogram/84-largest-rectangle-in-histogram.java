class Solution {
    public int largestRectangleArea(int[] arr) {
        
        int res = arr[0];
        // we need to find previous smaller element and next smaller element...
        
        int ps[] = new int[arr.length];
        int ns[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()){
                ps[i] = -1;
            }
            else ps[i] = st.peek();
            st.push(i);
        }       
        st.clear();
        
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) ns[i] = arr.length;
            else ns[i] = st.peek();
            
            st.push(i);
        }
        // System.out.println(Arrays.toString(ps));
        // System.out.println(Arrays.toString(ns));
        
        for(int i=0;i<arr.length;i++){
            res = Math.max(res, (ns[i]-ps[i]-1)*arr[i]);
        }
                
        return res;
    }
}