class Solution {
    HashSet<String> set;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        set = new HashSet<>();
        
        solve(sr,sc,image[sr][sc], color,image);
        
        return image;
        
    }
    
    public void solve(int i , int j , int startColor, int color, int arr[][]){
        String temp = i+","+j;
        
        if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != startColor || set.contains(temp)) return ;
        
        
        arr[i][j] = color;
        set.add(temp);
        
        solve(i-1,j,startColor,color,arr);
        solve(i+1,j,startColor,color,arr);
        solve(i,j-1,startColor,color,arr);
        solve(i,j+1,startColor,color,arr);
        
    }
    
}