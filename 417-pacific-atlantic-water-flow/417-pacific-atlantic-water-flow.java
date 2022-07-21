class Solution {
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};
    int ans[][];
    boolean vis[][];
    public List<List<Integer>> pacificAtlantic(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        vis = new boolean[m][n];
        Queue<int []> q = new LinkedList<>();
        ans = new int[m][n];
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            vis[0][i] = true;
            q.offer(new int[]{0,i});
            ans[0][i] = 1;
        }
        for(int i=1;i<m;i++){
            vis[i][0] = true;
            q.offer(new int[]{i,0});
            ans[i][0] = 1;
        }
        
        markCells(arr, q);
        
        
        vis = new boolean[m][n];
        
        
        for(int i=0;i<n;i++){
            vis[m-1][i] = true;
            q.offer(new int[]{m-1,i});
            ans[m-1][i] += 1;
        }
        for(int i=0;i<m-1;i++){
            vis[i][n-1] = true;
            q.offer(new int[]{i,n-1});
            ans[i][n-1] += 1;
        }
        
        markCells(arr, q);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Integer> temp = new ArrayList<>();
                if(ans[i][j] == 2) {
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        return list;
        
    }
    
    public void markCells(int arr[][] , Queue<int []> q){
        
        while(!q.isEmpty()){
            
            int curr[] = q.poll();
            for(int i=0;i<4;i++){
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];
                
                if(x >= 0 && y >= 0 && x < arr.length && y < arr[0].length && vis[x][y] == false && arr[x][y] >= arr[curr[0]][curr[1]]){
                    q.offer(new int[]{x,y});
                    vis[x][y] = true;
                    ans[x][y]+=1;
                }
                
            }
        }
    }
    
}