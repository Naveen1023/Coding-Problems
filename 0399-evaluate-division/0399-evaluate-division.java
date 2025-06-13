class Solution {
  
    public double[] calcEquation(List<List<String>> equations, 
                                 double[] values, List<List<String>> queries) {
        //build the graph
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);
        
        //we have to return the result in double so we make a double arr
        double[] result = new double[queries.size()];
        
        //Iterate through queries list to get the result
        for(int i = 0;  i < queries.size(); i++){
            String src = queries.get(i).get(0);
            String des = queries.get(i).get(1);
            
            //if any of them is not in the graph
            if (!graph.containsKey(src) || !graph.containsKey(des)){ 
                result[i] = -1.0;
                continue;
            }
            
            result[i] = dfs(src, des, graph, new HashSet());
        }
        return result;       
    }
    //call the dfs to solve the queries
    private double dfs(String src, String des, HashMap<String, 
                       HashMap<String, Double>> graph, Set<String> visited){
        
        //if src and destination is equal
         if (graph.get(src).containsKey(des)) {
            return graph.get(src).get(des);
        }
        
        
        //add to visited set
        visited.add(src);
        
        //go to next node of source
        for(Map.Entry<String , Double>next : graph.get(src).entrySet()){
            //check that is it already visited set contains the key 
            if(!visited.contains(next.getKey())){
                //now get the ans from dfs 
                double ans = dfs(next.getKey(), des, graph, visited);
                if(ans != -1.0){
                    //return the ans * value(weight) of current node
                     return ans * next.getValue();
                }
            }
        }
        return -1.0;
    }
    private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> eq, 
                                               double[] values){
        HashMap<String, HashMap<String, Double>> g = new HashMap<>();
        //Iterate through values
        for(int i = 0; i < values.length; i++){
            //get the source from the equations list
            String src = eq.get(i).get(0);
            //get the destination from the equations list
            String des = eq.get(i).get(1);
            //put the src in the graph if it is not present
            g.putIfAbsent(src, new HashMap());
            //put the destination in the graph if it is not present
            g.putIfAbsent(des, new HashMap());
            //add a edge from src to destination with values weight
            g.get(src).put(des, values[i]);
            //add a edge from destination to source with 1/weight
            g.get(des).put(src, 1.0 / values[i]);
        }
        return g;
    }
}