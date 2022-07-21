class Solution {
    int id = 100;
    public int largestIsland(int[][] arr) {
        id = 100;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 1){
                    int size[] = {0} ;
                    solve(i,j,arr,map,n,size);
                    map.put(id++, size[0]);
                    //System.out.println("size = "+size[0]);
                    res = Math.max(size[0], res);
                }               
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 0){
                    
                    int dx[] = {0,0,1,-1};
                    int dy[] = {1,-1,0,0};
                    for(int k=0;k<4;k++){
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if(x >=0 && y >= 0 && x < n && y < n && arr[x][y]!=0){
                            set.add(arr[x][y]);  // storing id of all island adjacent to that 0
                        }
                    }
                    int sum = 1; // 0 is also the part of island now....
                    for(int id : set){
                        sum+=map.get(id);
                        
                    }
                    set.clear();
                    res = Math.max(res, sum);
                }
            }
        }
        return res;
    }
    public int solve(int i, int j, int arr[][], HashMap<Integer, Integer> map,int n, int size[]){
        
        size[0]++;
        arr[i][j] = id;
        
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        for(int k=0;k<4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            
            if(isValid(x,y,arr, n)  == true){
                solve(x,y, arr,map,n,size);
            }
            
        }
        return size[0];
    }
    public boolean isValid(int x , int y , int arr[][] , int n){
        if(x >= 0 && y >= 0 && x < n && y < n && arr[x][y] == 1) return true;
        return false;
    }
    
}