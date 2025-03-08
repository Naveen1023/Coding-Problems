class Solution {
    public boolean canJump(int[] arr) {
        int maxReach = 0;
        for(int i=0;i<arr.length;i++) {
            if(maxReach < i) return false;
            maxReach = Math.max(maxReach, i+arr[i]);
            if(maxReach >= arr.length-1) return true;
        }
        return false;
    }
}

/**
travel left to right, maintains the max reach index.
if maxReach exceeds last index => true
if maxReach < currIdx => false
 */