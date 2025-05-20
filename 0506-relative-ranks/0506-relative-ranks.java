class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String res[] = new String[n];

        int temp[] = score.clone();
        Arrays.sort(temp);
        HashMap<Integer, String> map = new HashMap<>();

        for(int i=0;i<temp.length;i++) {
            String value = Integer.toString(n-i);
            if(i == n-1) value = "Gold Medal";
            if(i == n-2) value = "Silver Medal";
            if(i == n-3) value = "Bronze Medal";

            map.put(temp[i], value);
        }

        for(int i=0;i<score.length;i++) {
            res[i]  = map.get(score[i]);
        }
        return res;
    }
}