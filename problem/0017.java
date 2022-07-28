class Solution {
    Map<Character, String> digitMap;
    
    public List<String> letterCombinations(String digits) {
        // // method 1, recursive, time = O(4^N), space = O(4^N)
        // digitMap = new HashMap() {{
        //     put('2', "abc");
        //     put('3', "def");
        //     put('4', "ghi");
        //     put('5', "jkl");
        //     put('6', "mno");
        //     put('7', "pqrs");
        //     put('8', "tuv");
        //     put('9', "wxyz");            
        // }};
        // return combineRecur(digits, 0);
        
        // method 2, loop to iterate, time = O(4^N), space = O(4^N)
        List<String> ans = new ArrayList<>();
        String table[] = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            String chars = table[Integer.valueOf(String.valueOf(digits.charAt(i)))];            
            if (ans.isEmpty()) {
                for (int j = 0; j < chars.length(); j++) {
                    ans.add(String.valueOf(chars.charAt(j)));
                }
            } else {
                List<String> temp = new ArrayList<>();
                for (String element: ans) {                    
                    for (int j = 0; j < chars.length(); j++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(element).append(chars.charAt(j));
                        temp.add(sb.toString());
                    }
                }  
                ans = temp;
            }
        }        
        return ans;
    }
    
    // private List<String> combineRecur(String digits, int i) {
    //     if (digits.isEmpty()) return new ArrayList();
    //     if (i == digits.length() - 1) return Arrays.asList(digitMap.get(digits.charAt(i)).split(""));        
    //     List<String> result = new ArrayList();
    //     for (char curLetter : digitMap.get(digits.charAt(i)).toCharArray()) {
    //         for (String substr : combineRecur(digits, i + 1)) {
    //             StringBuilder sb = new StringBuilder();
    //             sb.append(curLetter).append(substr);
    //             result.add(sb.toString());                
    //         }
    //     }
    //     return result;
    // }
}