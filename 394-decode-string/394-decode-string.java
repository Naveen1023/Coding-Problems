class Solution {
    public String decodeString(String s) {
        
        Queue<Character> q = new LinkedList<>();
        for(char ch : s.toCharArray()){
            q.offer(ch);
        }
        return solve(q);
    }
    
    public String solve(Queue<Character> q){
        
        StringBuilder temp = new StringBuilder();
        
        int num = 0;
        while(!q.isEmpty()){
            char ch = q.poll();
            
            if(Character.isDigit(ch)){
                num = num * 10 + ch-'0';
            }
            else if (ch == '[') {
                String sub = solve(q);
                for (int i = 0; i < num; i++) temp.append(sub);   
                num = 0;
            }
            else if(ch == ']'){
                break;
            }
            else{ //means a character
                temp.append(ch);
            }
        }
        return temp.toString();
        
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