class Solution {
    public int reverse(int x) {
//         // method 1, use array to store and process
//         int DIGITS_SIZE = 10;
//         boolean isPostive = x >= 0;
//         int[] nums = new int[DIGITS_SIZE];
//         int count = 0;
//         while (x != 0 && count < DIGITS_SIZE) {
//             nums[count++] = x % 10;
//             x /= 10;
//         }
//         int result = 0;
//         for (int i = count - 1; i >= 0; i--) {
//             // check int overflow
//             if ((isPostive && (nums[i] > (Integer.MAX_VALUE - result) / Math.pow(10, count - i - 1))) ||
//                (!isPostive && (nums[i] < (Integer.MIN_VALUE - result) / Math.pow(10, count - i - 1)))) return 0;
//             result += nums[i] * Math.pow(10, count - i - 1);
//         }
//         return result;

//         // method 2, offical soultion, process in every step
//         int rev = 0;
//         while (x != 0) {
//             int pop = x % 10;
//             x /= 10;
//             if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
//             if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
//             rev = rev * 10 + pop;
//         }
//         return rev;

        // method 3, 
        // https://leetcode.com/problems/reverse-integer/discuss/4060/My-accepted-15-lines-of-code-for-Java
        int result = 0;
        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) return 0;
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}