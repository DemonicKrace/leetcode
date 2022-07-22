public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // method 1, iterate every bit and swap, time = O(N), space = O(1), N = bits count
        int BITS_SIZE = 32;
        int reverse = 0;
        for (int offset = 0; offset < BITS_SIZE; offset++) {
            reverse |= ((n >> offset) & 1) << (BITS_SIZE - offset - 1);
        }
        return reverse;
    }
}