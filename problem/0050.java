class Solution {
    public double myPow(double x, int n) {
        // method 1, math, time = O(logN), space = O(1)
        return dcPow(x, n);
    }
    
    private double dcPow(double x, long n) {
        if (n == 0) return 1.0;
        if (n < 0) return 1.0 / dcPow(x, -n);
        double half = dcPow(x, n / 2);
        if (n % 2 == 1) return half * half * x;
        else return half * half;        
    }
}