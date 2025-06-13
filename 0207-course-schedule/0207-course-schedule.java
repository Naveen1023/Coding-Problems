class Solution {
    public boolean canFinish(int n, int[][] arr) {
        int inDeg[] = new int[n];

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i, new ArrayList<>());

        for(int a[] : arr) {
            int u = a[0];
            int v = a[1];
            inDeg[u]++;
            map.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++) {
            if(inDeg[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int neigh : map.get(node)) {
                inDeg[neigh]--;
                if(inDeg[neigh] == 0) q.offer(neigh);
            }
        }

        for(int ele : inDeg){
            if(ele != 0) return false;
        }
        return true;
    }
}