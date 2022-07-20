/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair {
    TreeNode node;
    int dep;
    
    Pair(TreeNode node, int d){
        this.node = node;
        dep = d;
    }
        
}
class Solution {
    public TreeNode recoverFromPreorder(String s) {
       Stack<Pair> st = new Stack<>();
        TreeNode res = null;
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '-'){
                count++;
            }
            else{
                int start = i;
                while(i < s.length() && s.charAt(i) != '-') i++;
                
                String str = s.substring(start,i);
                // System.out.println(str);
                int val = Integer.parseInt(str);
                TreeNode temp = new TreeNode(val);
                if(count == 0) res = temp;                
                Pair p = new Pair(temp,count);
                
                
                while(!st.isEmpty() && count != st.peek().dep+1){
                    st.pop();   
                }             
                if(!st.isEmpty() && st.peek().node.left == null){
                    st.peek().node.left = temp;
                }
                else if(!st.isEmpty()){
                    st.peek().node.right = temp;
                }
                count = 0;
                 st.push(p); 
                i--;
            }
        }
        
//         while(st.size() > 1) {
//             Pair p = st.pop();
//             System.out.println(p.node.val+" "+p.dep);
//         }
        
//         return st.peek().node;
       return res;
    }
    
    
    
    public TreeNode solve(String s, int d){
        
        if(s.length() == 0) return null;
        if(s.length() == 1){
            return new TreeNode(s.charAt(0)-'0');
        }
        
        
        int val = s.charAt(0) - '0';
        TreeNode node = new TreeNode(val);
        
        String newD = "-";
        while(d-- > 0){
            s = s + "-";
        }
        int index1 = s.indexOf(newD); // 1
        int index2 = s.lastIndexOf(newD); // 9
        
        if(index1 != index2){
            String temp = s.substring(index1+newD.length(),index2);
            System.out.println(temp);
            node.left = solve(temp, d+1);
            String temp2 = s.substring(index2+d+1);
            
            node.right = solve(temp2, d+1);
        }
        else{
            node.left = solve(s.substring(index1+d+1), d+1);
        }
        return node;
    }
    
}