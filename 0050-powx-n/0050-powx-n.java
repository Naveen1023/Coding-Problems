class Solution {
    public double myPow(double x, int nn) {
        double res = 1;
        long n = nn;
        if (nn < 0) {
            n = -n;
            x = 1 / x;
        }
        while (n != 0) {
            if (n % 2 == 1) {
                res = res * x;
            }
            x = x * x;
            n = n / 2;
        }
        return res;
    }
}