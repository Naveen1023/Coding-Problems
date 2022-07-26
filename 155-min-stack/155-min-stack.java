class MinStack {
    
    Stack<Integer> st;
    List<Integer> list;
    
    public MinStack() {
        st=  new Stack<>();
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(list.isEmpty() || val <= list.get(list.size()-1)) list.add(val);
    }
    
    public void pop() {
        int val = st.peek();
        if(list.get(list.size()-1) == val) list.remove(list.size()-1);
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return list.get(list.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */