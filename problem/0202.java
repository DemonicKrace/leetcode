class Solution {
    public boolean isHappy(int n) {
        Set<Integer> processed = new HashSet();
        while (!processed.contains(n)) {
            processed.add(n);
            n = squareSum(n);
        }
        return processed.contains(1);
    }
    
    private int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int curNum = n % 10;
            sum += curNum * curNum;
            n /= 10;
        }
        return sum;
    }
}

// 2022-08-02
class Solution {
    public boolean isHappy(int n) {
        // method 1, time = O(N), space = O(N), N = number digits length
        Set<Integer> computed = new HashSet();
        while (n != 1) {
            if (!computed.add(n)) return false;
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return true;
    }
}