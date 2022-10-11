class Solution {
    public boolean increasingTriplet(int[] arr) {
        TreeSet<Integer> l = new TreeSet<>();
        TreeSet<Integer> r = new TreeSet<>();
        
        int n  = arr.length;
        for(int i=n-1;i>=1;i--){
            r.add(arr[i]);
        }
        l.add(arr[0]);
        
        for(int i=1;i<n-1;i++){
            
            Integer lower = l.lower(arr[i]);
            Integer upper = r.higher(arr[i]);
            
            if(lower != null && upper != null)
                return true;
            
            l.add(arr[i]);
            r.remove(arr[i]);
        }
        return false;
    }
}