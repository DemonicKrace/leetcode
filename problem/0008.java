class Solution {
    public int myAtoi(String s) {
        // reference by offical solution
        s = s.trim();
        int sign = 1;
        int result = 0;
        int i = 0;
        if (s.isEmpty()) return 0;
        else if (s.charAt(i) == '-') { i++; sign = -1; }
        else if (s.charAt(i) == '+') { i++; }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + digit;
            i++;
        }
        return result * sign;      
    }
}