class Solution {
    public boolean isValid(String s) {
        // method 1, stack, time = O(N), space = O(N)
        Map<Character, Character> map = new HashMap() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');            
        }};
        Deque<Character> stack = new ArrayDeque();
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) stack.push(c);
            else if (stack.isEmpty() || map.get(stack.pop()) != c) return false;
        }
        return stack.isEmpty();
    }
}