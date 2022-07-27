class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        // int right[] = new int[n];
        left[0] = arr[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1] , arr[i]);
        }
        int right = arr[n-1];
        
        int res = 0;
        for(int i=n-2;i>=0;i--){
            int currWater = Math.min(left[i],right) - arr[i];
            currWater = (currWater < 0) ? 0 : currWater;
            res += currWater;
            right = Math.max(right, arr[i]);
        }
        return res;
        // Stack<Integer> st=  new Stack<>();
        // for(int i=0;i<n;i++){  // monotonically decreasing elements...
        //     while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
        //     if(st.isEmpty()) left[i] = -1;
        //     else left[i] = st.peek();
        //     st.push(arr[i]);
        // }    
        // st.clear();
        // System.out.println(Arrays.toString(left));
        // for(int i=n-1;i>=0;i--){
        //     while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
        //     if(st.isEmpty()) right[i] = -1;
        //     else right[i] = st.peek();
        //     st.push(arr[i]);
        // }
        // System.out.println(Arrays.toString(right));
        // int res = 0;
        // for(int i=0;i<n;i++){
        //     int currWater = 0;
        //     if(left[i] != -1 && right[i] != -1) {
        //         currWater = Math.min(left[i],right[i]) - arr[i];
        //         res += currWater;
        //     }
        //     System.out.print(currWater+", ");
        // }
        // return res;
    }
}