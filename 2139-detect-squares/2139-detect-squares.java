class DetectSquares {
    HashMap<String, Integer> map ;
    List<int []> list;
    public DetectSquares() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void add(int[] point) {
        map.put(point[0]+"_"+point[1] , map.getOrDefault(point[0]+"_"+point[1], 0)+1);
        list.add(new int[]{point[0], point[1]});
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int res = 0;
        for(int curr[] : list) {
            int xTemp = curr[0];
            int yTemp = curr[1];
            //check if this point can be the diagonal point to the querying point.
            // means two more points should exist at (x, ytemp) and (xTemp, y). 
            // Just need to get the freq now...

            if(xTemp != x && yTemp != y && (Math.abs(xTemp - x) == Math.abs(yTemp - y))) {
                int diag = 1;
                int firstP = map.getOrDefault(x+"_"+yTemp,0);
                int secondP = map.getOrDefault(xTemp+"_"+y, 0);

                System.out.println("diag : "+diag+", firstP : "+firstP+", secondP : "+secondP);

                res +=  diag * firstP * secondP;
            }
            // System.out.println("res : "+res);
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */