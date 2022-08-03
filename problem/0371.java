class Solution {
    public int getSum(int a, int b) {
        // method 1, bit manipulate, time = O(N), space = (1), N = bits length
        int SIZE = 32;
        int carry = 0;
        int n = 0;
        for (int offset = 0; offset < SIZE; offset++) {
            int bitSum = carry == 1 ? 1 : 0;
            if (((a >> offset) & 1) == 1) bitSum++;
            if (((b >> offset) & 1) == 1) bitSum++;
            carry = bitSum > 1 ? 1 : 0;
            int curBit = bitSum % 2;
            n |= curBit << offset;            
        }
        return n;
    }
}