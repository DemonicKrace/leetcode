class Solution {
    public List<String> generateParenthesis(int n) {
        // // method 1, recursive and memorize, time = O(N^3), space = O(M), M = Catalan number
        // return generateRecur(n, new HashMap());

        // method 2, backtrack, time = O(M), space = O(M), M = Catalan number
        // compare to method 1, backtrack avoids unnecessary duplicated sub solution 
        List<String> result = new ArrayList<String>();
        generateBacktrack(result, "", 0, 0, n);
        return result;
    }
    
    // private List<String> generateRecur(int n, Map<Integer, List<String>> mem) {
    //     if (n == 0) return Arrays.asList("");
    //     if (mem.containsKey(n)) return mem.get(n);
    //     List<String> result = new ArrayList();
    //     for (int i = 0; i < n; i++) {
    //         for (String leftPart: generateRecur(i, mem)) {
    //             for (String rightPart: generateRecur(n - i - 1, mem)) {
    //                 result.add("(" + leftPart + ")" + rightPart);
    //             }
    //         }
    //     }
    //     mem.put(n, result);
    //     return result;
    // }
    
    private void generateBacktrack(List<String> result, String cur, int left, int right, int n) {
        if (cur.length() == n * 2) {
            result.add(cur);
            return;
        }
        if (left < n)
            generateBacktrack(result, cur + "(", left + 1, right, n);
        if (right < left)
            generateBacktrack(result, cur + ")", left, right + 1, n);
    }
}