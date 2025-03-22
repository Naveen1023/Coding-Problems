class Solution {
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;

        for(int ele : arr) set.add(ele);

        for(int i=0;i<arr.length;i++) {
            int curr = arr[i];
            int left = curr-1, leftC = 0;
            int right = curr+1, rightC = 0;
            while(set.contains(left)) {
                set.remove(left);
                leftC++;
                left--;
            }
            while(set.contains(right)) {
                set.remove(right);
                rightC++;
                right++;
            }
            // System.out.println("curr : "+curr+" left: "+leftC+", right: "+rightC);

            res = Math.max(res, leftC + rightC + 1);
        }

        return res;
    }
}

/**
1. sort and find out -> O(nlogn)
2.  - store it in set => for currElement => find left side seq and right side seq, left+right+1 
    - maintain the overall res

 */