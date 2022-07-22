class Solution {
    public int countPrimes(int n) {
        // optimize way
        // https://leetcode.com/problems/count-primes/discuss/57593/12-ms-Java-solution-modified-from-the-hint-method-beats-99.95
        // method 1, record as table, time = O(N), space = O(N)
        boolean[] notPrime = new boolean[n + 1];
        for (int i = 2; i * i < n; i++) {
            if (notPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                notPrime[j] = true;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) 
            if (!notPrime[i]) 
                count++;
        return count;
    }
}