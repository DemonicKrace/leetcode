class Solution {
    public int maxRepeating(String sequence, String word) {
        // method 1, brute force, time = O(N^2), space = O(N)
        int k = 0;
        String target = word;
        while (sequence.contains(target)) {
            k++;
            target += word;
        }
        return k;
    }
}