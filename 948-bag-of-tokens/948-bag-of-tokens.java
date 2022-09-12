class Solution {
    
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        int score = 0;
        int res = 0;
        // if(tokens.length == 1){
        //     return (tokens[0] <= power) ? 1 : 0;
        // }
        
        
        int i=0,j=tokens.length-1;
        
        // choose minimum power to lost when playing face UP
        // choose maximum power to gain when playing face down
        while(i <= j){
            
            if(power >= tokens[i]){
                power -= tokens[i++];
                score++;
            }
            else{
                if(score < 1) break;
                power+=tokens[j--];
                score--;
            }
            res = Math.max(res, score);
        }
        
        return res;
    }
}