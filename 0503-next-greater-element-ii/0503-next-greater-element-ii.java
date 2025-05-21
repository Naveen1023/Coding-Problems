class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            st.push(arr[i]);
        }
        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && st.peek() <= arr[i]) st.pop();

            res[i] = (st.isEmpty() == false) ? st.peek() : -1;
            st.push(arr[i]);
        }
        return res;
    }
}