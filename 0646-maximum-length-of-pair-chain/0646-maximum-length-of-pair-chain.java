class Solution {
    static int res;
    public int findLongestChain(int[][] pairs) {
        res = 0;
        Arrays.sort(pairs, (a,b) -> (a[0] != b[0]) ? a[0]-b[0] : a[1]-b[1]);

        // for(int a[] : pairs)
        //     System.out.println(Arrays.toString(a));

        int chainsLen[] = new int[pairs.length];
        Arrays.fill(chainsLen, 1);

        solve(0, pairs, chainsLen);

        // System.out.println(Arrays.toString(chainsLen));

        return res;
    }

    private void solve(int i, int arr[][], int chainsLen[]) {
        
        if(i == arr.length) return;

        for(int j=i;j>=0;j--) {
            int pair[] = arr[j];
            if(arr[i][0] > pair[1]) {
                chainsLen[i] = Math.max(chainsLen[i], 1 + chainsLen[j]);
            }
        }
        res = Math.max(res, chainsLen[i]);
        solve(i+1, arr, chainsLen);
    }
}

/*

.......................
                         .......
        ...................

*/