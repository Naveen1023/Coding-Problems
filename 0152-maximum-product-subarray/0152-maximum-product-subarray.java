class Solution {
    public int maxProduct(int[] arr) {
        int res = Integer.MIN_VALUE;

        int prod = 1;
        for (int i = 0; i < arr.length; i++) {
            prod *= arr[i];
            res = Math.max(res, prod);

            if (prod == 0) {
                prod = 1;
            }
        }
        prod = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            prod *= arr[i];
            res = Math.max(res, prod);

            if (prod == 0) {
                prod = 1;
            }
        }
        return res;
    }
}

/**
 * 1. Brute force of finding all subsets O(n^2)
 * 2. Kadane Algo. => max(left to right, right to left). 
reasoning : we just need to exclude one -ve number if there are odd -ve numbers. For the rest we can simply multiply. Handle 0 by resetting the product.
 * 
 */