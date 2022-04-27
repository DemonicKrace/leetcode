class Solution {
    public int getMaximumGenerated(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int maxV = 0;
        for (int i = 2; i <= n; i++) {
            arr[i] = (i % 2 == 0 ? arr[i / 2] : arr[i / 2] + arr[i / 2 + 1]);
            maxV = Math.max(maxV, arr[i]);
        }
        return maxV;
    }
}