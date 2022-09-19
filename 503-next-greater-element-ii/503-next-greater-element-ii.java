class Solution {
    public int[] nextGreaterElements(int[] arr) {
        // circular means {1,5,3,4,3} angain {1,5,3,4,3}.. 
        //                        (i) ans will be 5 
        
//         Stack<Integer> st= new Stack<Integer>();
//         for(int i=arr.length-1;i>=0;i--){
//             while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
//             if(st.isEmpty()){} // do nothing...
//             else{} // do nothing...
//             st.push(arr[i]);    
//         }
       
//         // System.out.println(st);
//         for(int i=arr.length-1;i>=0;i--){
//             int curr = arr[i];
//             while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            
//             if(st.isEmpty()) arr[i] = -1;
//             else arr[i] = st.peek();
            
//             st.push(curr);    
//         }
//         return arr;
        int n = arr.length, index = 0;
        int res[] = new int[n];
        Stack<Integer> st=  new Stack<>();
//          3 2 4
//          3 
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            
            // res[index++] = st.peek();
            st.push(arr[i]);
            
        }
        
        // st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            if(st.isEmpty()) {
                res[i] = -1;
            }
            else res[i] = st.peek();
            st.push(arr[i]);
        }
        
        return res;
        
    }
}