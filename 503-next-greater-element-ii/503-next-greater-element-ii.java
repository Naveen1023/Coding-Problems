class Solution {
    public int[] nextGreaterElements(int[] arr) {
        // circular means {1,5,3,4,3} angain {1,5,3,4,3}.. 
        //                        (i) ans will be 5 
        
        Stack<Integer> st= new Stack<Integer>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            if(st.isEmpty()){} // do nothing...
            else{} // do nothing...
            st.push(arr[i]);    
        }
       
        // System.out.println(st);
        for(int i=arr.length-1;i>=0;i--){
            int curr = arr[i];
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            
            if(st.isEmpty()) arr[i] = -1;
            else arr[i] = st.peek();
            
            st.push(curr);    
        }
        return arr;
    }
}