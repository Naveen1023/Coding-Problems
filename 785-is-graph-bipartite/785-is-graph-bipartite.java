class Solution {
    public boolean isBipartite(int[][] adj) {
        
        // 2 colors to the graph..if poosible => bipartite otherwise not
        boolean vis[] = new boolean[adj.length];
        int color[] = new int[adj.length];
        
        for(int i=0;i<adj.length;i++){
            if(!vis[i]){
                if(solve(i,0,color,vis,adj) == false) return false;
            }
        }
        
        return true;
        
    }
    
    public boolean solve(int node,int currCol, int color[],boolean vis[], int adj[][]){
        
        color[node] = currCol;
        vis[node] = true;
        
        
        for(int ele : adj[node]){
            
            if(vis[ele] == false){
                if(solve(ele, 1-currCol,color, vis, adj) == false) return false;
            }
            else{
                if(color[ele] == currCol) return false;
            }
            
        }
        return true;
        
    }
    
}