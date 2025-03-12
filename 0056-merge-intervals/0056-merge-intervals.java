class Solution {
    public int[][] merge(int[][] arr) {
        List<int []> list = new ArrayList<>();
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        for(int i=0; i < arr.length; i++) {
            int j = i;
            int temp[] = {arr[i][0], arr[i][1]};
            while(j < arr.length && arr[j][0] <= temp[1] ) {
                temp[0] = arr[i][0];
                temp[1] = Math.max(arr[j][1], temp[1]);
                j++;
            }
            i = j-1;
            list.add(temp);
        }
        int res[][] = new int[list.size()][2];
        for(int i=0;i<res.length;i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }

        return res;
    }
}
/**
[[1,3],[2,6],[8,10],[15,18]]

 */