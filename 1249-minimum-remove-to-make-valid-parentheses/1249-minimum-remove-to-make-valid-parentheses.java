class Solution {
    public String minRemoveToMakeValid(String s) {
     
        char arr[] = s.toCharArray();
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '(')
                st.push(i);
            else if(arr[i] == ')'){
                if(st.isEmpty() == true){
                    arr[i] = '*';
                }
                else{
                    st.pop();
                }
            }
        }
        
        while(!st.isEmpty()){
            arr[st.pop()] = '*';
        }
        
        StringBuilder str = new StringBuilder();
        for(char ch : arr){
            if(ch!='*')
                str.append(ch);
        }
        return str.toString();
    }
}