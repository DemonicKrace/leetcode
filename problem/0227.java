class Solution {
    public int calculate(String s) {
        // // method 1, use stack
        // Deque<Integer> stack = new ArrayDeque<Integer>();
        // int curNum = 0;
        // char operator = '+';
        // int n = s.length();
        // for (int i = 0; i < n; i++) {
        //     char c = s.charAt(i);     
        //     if (Character.isDigit(c)) curNum = (curNum * 10) + (c - '0');
        //     if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1) {
        //         if (operator == '+') {
        //             stack.push(curNum);
        //         } else if (operator == '-') {
        //             stack.push(-curNum);                    
        //         } else if (operator == '*') {
        //             stack.push(stack.pop() * curNum);
        //         } else if (operator == '/') {
        //             stack.push(stack.pop() / curNum);
        //         }
        //         operator = c;
        //         curNum = 0;
        //     }
        // }
        // return stack.stream().mapToInt(Integer::intValue).sum();

        // method 2, Space O(1)
        int result = 0;
        int curNum = 0;
        int lastNum = 0;
        char operator = '+';
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);    
            if (Character.isDigit(c)) curNum = (curNum * 10) + (c - '0');
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1) {
                if (operator == '+') {
                    result += lastNum;
                    lastNum = curNum;
                } else if (operator == '-') {
                    result += lastNum;
                    lastNum = -curNum;
                } else if (operator == '*') {
                    lastNum *= curNum;
                } else if (operator == '/') {
                    lastNum /= curNum;
                }
                operator = c;
                curNum = 0;
            }
        }
        result += lastNum;
        return result;
    }
}