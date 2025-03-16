class Solution {
    public void setZeroes(int[][] arr) {

        boolean zeroInFirstRow = false, zeroInFirstCol = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    if (i == 0)
                        zeroInFirstRow = true;
                    if (j == 0)
                        zeroInFirstCol = true;
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }
        // for (int a[] : arr) {
        //     System.out.println(Arrays.toString(a));
        // }

        for (int j = 1; j < arr[0].length; j++) {
            if (arr[0][j] == 0) {
                for (int i = 1; i < arr.length; i++)
                    arr[i][j] = 0;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] == 0) {
                for (int j = 1; j < arr[0].length; j++)
                    arr[i][j] = 0;
            }
        }

        if (zeroInFirstRow) {
            for (int i = 0; i < arr[0].length; i++)
                arr[0][i] = 0;
        }
        if (zeroInFirstCol) {
            for (int i = 0; i < arr.length; i++)
                arr[i][0] = 0;
        }

    }
}