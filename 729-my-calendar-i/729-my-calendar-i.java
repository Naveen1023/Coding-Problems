class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();        
    }
    
    public boolean book(int start, int end) {
        
        Integer prevEnd = map.floorKey(start);
        if(prevEnd != null) prevEnd  = map.get(prevEnd);

        Integer nextStart = map.ceilingKey(start);
        
        if(prevEnd != null && start < prevEnd) return false;
        if(nextStart != null && end > nextStart) return false;
        
        map.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */