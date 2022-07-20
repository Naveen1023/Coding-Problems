class Solution {
    static int res = 0;
    public int lengthOfLIS(int[] arr) {
        
        
         // .............................RECURSIVE + MEMO.............................
        // int t[][] = new int[arr.length+1][arr.length+1];
        // for(int a[] : t)
        //     Arrays.fill(a, -1);
        // return solve(0,-1,arr,t);
        
        
        // ...........................TABULATION........................................
        
        // for(int i=arr.length-1;i>=0;i--){
        //     for(int prev = i-1;prev>=-1;prev--){
        //         if(prev == -1 || arr[i] > arr[prev]){
        //             t[i][prev+1] = Math.max(1 + t[i+1][i+1], t[i+1][prev+1]);
        //         }
        //         else 
        //             t[i][prev+1] = t[i+1][prev+1];
        //     }
        // }
        // return t[0][0];
        
        // ...............................OPTIMAL SOLUTION.................................
        
        int t[] = new int[arr.length];
        int res = 1;
        //at every index, store the longest increasing subseq till that index........
        Arrays.fill(t, 1);
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j] < arr[i])
                    t[i] = Math.max(t[i], 1+t[j]);
            }
            res = Math.max(res, t[i]);
        }
        // ............................Print LIS.................................../
        // printLIS(arr);
        
        // return res;
        
        
        // ............................OPTIMAL (binary Search).................................
        // since the seq will be in increasing order, we can simulate similar thiing and apply binary search....NOTE that this is jsut for find out length. We can not get exact LIS through this method....
        return solveBinarySearch(arr);
        
        
    }
	public static int solve(int i, int prev,int arr[], int t[][]){
	    if(i == arr.length) return 0;
        if(t[i][prev+1] != -1) return t[i][prev+1];
        if(prev == -1 || arr[i] > arr[prev]){
            return t[i][prev+1] = Math.max(1 + solve(i+1,i,arr,t), solve(i+1,prev,arr,t));
        }
        else return t[i][prev+1] = solve(i+1,prev,arr,t);
    } 
    
    public static void printLIS(int arr[]){
        int t[] = new int[arr.length];
        int hash[] = new int[arr.length]; // will store the previous index to which curr ele was added
        
        int res_index = 0;
        //at every index, store the longest increasing subseq till that index........
        Arrays.fill(t, 1);
        for(int i=1;i<arr.length;i++){
            hash[i] = i;
            for(int j=i-1;j>=0;j--){
                if(arr[j] < arr[i] && t[i] < t[j]+1){
                    hash[i] = j;
                    t[i] = 1 + t[j];
                }
            }
            res_index = (t[i] > t[res_index]) ? i: res_index;
        }
        // System.out.println(Arrays.toString(t));
        // System.out.println(Arrays.toString(hash));
        int temp = res_index;
        // System.out.print(res_index);
        List<Integer> list = new ArrayList<>();
        while(list.size() < t[res_index]){
            list.add(arr[temp]);
            temp = hash[temp];
            
        }
        Collections.reverse(list);
        System.out.println(list);
        
    }
    
    public int solveBinarySearch(int arr[]){
        List<Integer> list = new ArrayList<>();
          for(int i=0;i<arr.length;i++){
              if(list.isEmpty()) list.add(arr[i]);
              else{
                  int index = lower_bound(list, arr[i]);
                  if(index == -1) list.add(arr[i]);
                  else list.set(index,arr[i]);
              }
          }
        return list.size();
    }
    // this will give index of target if exists, otherwise index of element just greater than target
    public int lower_bound(List<Integer> list, int target){
      
        int l = 0;
        int r = list.size()-1;
        int ans = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(list.get(mid) < target){
                l = mid+1;
            }
            else {
                ans = mid;
                r = mid-1;
            }
        }        
        return ans;
    }
    
}










