class Solution {
    public int trailingZeroes(int n) {
        // // https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52371/My-one-line-solutions-in-3-languages
        // int count = 0;
        // while (n / 5 > 0) {
        //     n /= 5;
        //     count += n;
        // }
        // return count;

        // 2022-08-02
        // method 1, count factor 5, time = O(logN)
        int count = 0;
        while (n > 1) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
