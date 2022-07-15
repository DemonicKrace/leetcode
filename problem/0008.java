class Solution {
    public int myAtoi(String s) {
        // method 1, reference by offical solution
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

        // method 2, check overflow and underflow by limit range
        s = s.trim();
        boolean isPostive = true;
        boolean isAfterFirstRound = false;
        int result = 0;
        for (char c: s.toCharArray()) {
            if (c == '-' || c== '+') {
                // invalid symbol after first round
                if (isAfterFirstRound) break;
                isPostive = (c == '-') ? false : true ;
            }
            else if (Character.isDigit(c)) {
                int digit = c - '0';
                // check number is not greater than Integer.MAX_VALUE
                if (isPostive && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7))) return Integer.MAX_VALUE;
                // check number is not smaller than Integer.MIN_VALUE
                if (!isPostive && (result * -1 < Integer.MIN_VALUE / 10 || (result * -1 == Integer.MIN_VALUE / 10 && digit > 8))) return Integer.MIN_VALUE;
                result = result * 10 + digit;
            } else {
                // invalid character
                break;
            }
            // first round is start
            if (!isAfterFirstRound) isAfterFirstRound = true;
        }
        return isPostive ? result : - result;

        // method 3, check overflow and underflow by compare previous result
        s = s.trim();
        boolean isPostive = true;
        boolean isAfterFirstRound = false;
        int result = 0;
        int newResult = 0;
        for (char c: s.toCharArray()) {
            if (c == '-' || c== '+') {
                // invalid symbol after first round
                if (isAfterFirstRound) break;
                isPostive = (c == '-') ? false : true;
            }
            else if (Character.isDigit(c)) {
                int digit = c - '0';
                newResult = result * 10 + digit;
                // newResult divide 10 wil not equal result when overflow
                if (newResult / 10 != result) return isPostive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result = newResult;
            } else {
                // invalid character
                break;
            }
            // first round is start
            if (!isAfterFirstRound) isAfterFirstRound = true;
        }
        return isPostive ? result : -result;
    }
}