class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '(') st.push(i);
            else if (ch == '*') st2.push(i);
            else {
                if(st.isEmpty() && st2.isEmpty()) return false;
                else if (!st.isEmpty()) {
                    st.pop();
                }
                else st2.pop();
            }
        }

        while(!st.isEmpty() && !st2.isEmpty()) {
            if(st.pop() > st2.pop()) return false;
        }
        return (st.size() > 0) ? false : true;
    }
}

/**
- Push ( in the stack. What to do with * ?
- Let's say you keep them at seprate stack. 
- When you encounter ) => let's try to resolve the know braces first => pop the (
- Now, post whole string traversal,  only ( and * are left.
- (* is fine but *( is not

 */