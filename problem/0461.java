class Solution {
    public int hammingDistance(int x, int y) {
        // method 1, iterate ervery bit, time = O(N), space = O(1), N = bits count
        int BITS_SIZE = 32;
        int z = x ^ y;
        int diff = 0;
        for (int offset = 0; offset < BITS_SIZE; offset++) 
            if (((z >> offset) & 1) == 1)
                diff++;
        return diff;
    }
}