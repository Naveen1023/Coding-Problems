class Solution {
    public int countStudents(int[] stu, int[] sand) {
        
        // top sandwich is going to be consumed by the student any where in the queue if he likes it...
        int one =0;
        int zero = 0;
        
        for(int ele : stu){
            if(ele == 1) one++;
            else zero++;
        }
        
        for(int s : sand){
            if(s==1){
                if(one > 0) one--;
                else return zero;
            }
            else{
                if(zero > 0) zero--;
                else return one;
            }   
            
        }
        
        return 0;
        
    } 
//         Queue<Integer> q = new LinkedList<>();
        
//         int index = 0;
        
//         for(int ele : stu)
//             q.offer(ele);
        
//         while(!q.isEmpty()){
//             int size = q.size();
//             int count = 0;
//             while(!q.isEmpty() && q.peek() != sand[index]){
//                 count++;
//                 int temp = q.poll();
//                 q.add(temp);
//                 if(count > size) return size; // we rorated once still not equals to the top sandwich
//             }
//             q.poll();
//             index++;
//         }
//         return 0;        
//     }
}