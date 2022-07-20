class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int count[] = new int[n];
        int res[] = new int[n];
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        
        for(int a[] : edges){
            int u = a[0];
            int v = a[1];
            list.get(u).add(v);
            list.get(v).add(u);    
        }
        
        //answer for current node will be distance to all the nodes below it and distance to all the nodes above or other side of it...\
        // lets count the distance for nodes below it....we will need number of nodes in each subtree including root node...
        solve(0,-1,list,count,res);
        // System.out.println(Arrays.toString(count));
        // System.out.println(Arrays.toString(res));
        
        solve2(0,-1,list,count,res);
        
        return res;
    }
    
    public void solve(int node,int parent,List<List<Integer>> list, int count[], int res[]){
            
        for(int ele : list.get(node)){
            if(ele != parent){
                solve(ele, node,list,count,res);
                count[node] = count[node] + count[ele]; 
                res[node] = res[node] + res[ele] + count[ele];
            }
        }
        count[node]+=1;  //include current node also...
    }
    public void solve2(int node, int parent, List<List<Integer>> list, int count[] , int res[]){
        for(int ele : list.get(node)){
            if(ele != parent){
                res[ele] = res[node] - count[ele] + (count.length - count[ele]);
                solve2(ele, node, list,count,res);
            }
        }
    }
    
}






