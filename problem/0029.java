class Solution {
    public int divide(int dividend, int divisor) {
        // method 1, bit manipulation, time = O(N), space = O(1), N = bits length
        // specail case
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int quotient = 0, offset = 0;
        int m = Math.abs(dividend), n = Math.abs(divisor);
        // can not use m >= n, when m = -2^31 will be incorrect
        while (m - n >= 0) {
            for (offset = 0; m - (n << offset << 1) >= 0; offset++);
            quotient += (1 << offset);
            m -= (n << offset);
        }
        return (dividend > 0) == (divisor > 0) ? quotient : -quotient;
    }
}