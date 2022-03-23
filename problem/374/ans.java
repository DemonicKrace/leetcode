public class Solution extends GuessGame {
    // solution 1, Binary search - Template #1
    public int guessNumber(int n) {
        if (n == 1) return 1;
        
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int ans = guess(mid);
            if (ans == 0) {
                return mid;
            } else if (ans == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;                
            }
        }
        return left;
    }
}