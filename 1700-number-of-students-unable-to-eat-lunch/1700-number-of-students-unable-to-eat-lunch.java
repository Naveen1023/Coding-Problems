class Solution {
    public int countStudents(int[] stu, int[] sand) {
        
        Queue<Integer> q = new LinkedList<>();
        
        int index = 0;
        
        for(int ele : stu)
            q.offer(ele);
        
        while(!q.isEmpty()){
            int size = q.size();
            int count = 0;
            while(!q.isEmpty() && q.peek() != sand[index]){
                count++;
                int temp = q.poll();
                q.add(temp);
                if(count > size) return size; // we rorated once still not equals to the top sandwich
            }
            q.poll();
            index++;
        }
        return 0;        
    }
}