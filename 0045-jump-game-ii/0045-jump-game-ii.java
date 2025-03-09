class Solution {
    public int jump(int[] arr) {
        int i = 0;
        int maxReach = 0;
        int res = 0;

        while(i < arr.length) {
            int j = i;
            int localMaxReach = maxReach;

            while(j < arr.length && j <= maxReach) {
                // find the maxReach from current options
                if(j + arr[j] > localMaxReach) {
                    localMaxReach = j + arr[j];
                }
                j++;
            }
            // System.out.println("i = "+i+", maxReach: "+maxReach+", localMaxReach: "+localMaxReach);
            if(maxReach >= arr.length-1) return res;

            if(localMaxReach > maxReach) {
                maxReach = localMaxReach;
                res++;
            }
            i = j;
        }

        return res;
    }
}

/**
- standing at ith index, you can jump till i+arr[i] 
- from the block (i to i+arr[i]) => make a choice to jump with best option
- the best option is the one which can reach the farthest.
- number of best options chosen are #jumps required.
{2,3,4,1,4,0}


 */