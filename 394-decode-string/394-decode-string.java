class Solution {
    public String decodeString(String s) {
        Stack<String> st= new Stack<>();
        Stack<Integer> counter = new Stack<>();
        int n = s.length();
        int i = 0;
        
        String res = "";
        while(i < s.length()){
            
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                int val = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i)-'0');
                    i++;
                }
                counter.push(val);
            }
            else if(ch == '['){
                st.push(res);
                res = "";
                i++;
            }
            else if(ch == ']'){
                String rep = st.pop();
                int times = counter.pop();
                while(times-- > 0){
                    rep += res;
                }
                res = rep;
                i++;
            }
            else{ // means this is jsut a character
                res += ch;
                i++;
            }
        }        
        
        
        return res;
    }
}

/*
res = "c"
13[a2[fc]]
val = 2
st = [a,
ct = [13, 2,
.............................

"2[abc]3[cd]ef"

[abc,cdcdcd,ef]
temp =  cd


*/