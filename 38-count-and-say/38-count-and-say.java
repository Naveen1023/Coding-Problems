class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String str = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<str.length();i++){
            int count = 0;
            char ch = str.charAt(i);
            int j = i;
            while(j < str.length() && str.charAt(j) == ch){
                count++;
                j++;
            }
            sb.append(count);
            sb.append(ch);
            i = j-1;
        }
        return sb.toString();        
    }
}