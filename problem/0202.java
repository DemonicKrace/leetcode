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