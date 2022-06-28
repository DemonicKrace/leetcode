class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int n = columnTitle.length();
        for (int i = 0; i < n; i++) {
            char letter = columnTitle.charAt(i);
            if (i == n - 1) sum += letter - 'A' + 1;
            else sum += Math.pow(26, (n - i - 1)) * (letter - 'A' + 1);
        }
        return sum;
    }
}