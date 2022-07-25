class Solution {
    public String countAndSay(int n) {
        // method 1, recursive, time = O(N^2), space = O(N)
        if (n == 1) return "1";
        return say(countAndSay(n - 1));
    }
    
    private String say(String text) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = text.charAt(0);
        for (int i = 1; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == prev) count++;
            else {
                sb.append(count).append(prev);
                count = 1;
            }
            prev = c;
        }
        sb.append(count).append(prev);
        return sb.toString();
    }
}