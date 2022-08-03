class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        boolean firstWord = true;
        
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            
            while(i >= 0 && s.charAt(i)!=' '){
                st.push(s.charAt(i--));
            }
            while(i >= 0 && s.charAt(i) == ' ') i--;
            i++;
            StringBuilder str = new StringBuilder();
            while(st.isEmpty() == false)
                str.append(st.pop());
            if(firstWord == false) res.append(" ");
            res.append(str);
            if(res.length() >= 1)firstWord = false;
        }
     return res.toString();   
    }
}