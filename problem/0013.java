class Solution {
    public int romanToInt(String s) {
        // method 1, loop, time = O(N), space = O(1)
        Map<Character, Integer> num = new HashMap() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};        
        int sum = 0;
        char prev = s.charAt(0);
        for (char c : s.toCharArray()) {
            // subtract prev more once, because prev already added previous round
            if (isSubtractCondition(prev, c)) sum += (num.get(c) - num.get(prev) * 2);
            else sum += num.get(c);
            prev = c;
        }
        return sum;
    }
    
    private boolean isSubtractCondition(char prev, char c) {
        if (prev == 'I' && (c == 'V' || c == 'X')) return true;
        if (prev == 'X' && (c == 'L' || c == 'C')) return true;
        if (prev == 'C' && (c == 'D' || c == 'M')) return true;
        return false;
    }
}