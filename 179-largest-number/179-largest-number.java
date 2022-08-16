

class Solution {
    public String largestNumber(int[] arr) {
        
        String a[] = new String[arr.length];
        int k =0;
        
        for(int ele : arr){
            a[k++] = String.valueOf(ele);
        }
        
        Comparator<String> comp = new Comparator<>(){
            
            public int compare(String a, String b){
                String s1 = a+b;
                String s2 = b+a;
                
                if(s1.compareTo(s2) < 0){ // means a+b is smaller, then we want b firsts as it is great
                    return 1;
                }
                else return -1;
            }
        };
        
        Arrays.sort(a, comp);
        
        StringBuilder res = new StringBuilder();
        for(String ele : a) res.append(ele);
        
        if(res.charAt(0) == '0') return "0";
        
        return res.toString();
    }
}

// (String.valueOf(a)+String.valueOf(b))
// (String.valueOf(b)+String.valueOf(a))