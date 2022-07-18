class Solution {
    // https://leetcode.com/problems/longest-common-prefix/solution/
    public String longestCommonPrefix(String[] strs) {        
        // // brute
        // String prefix = "";
        // for (int i = 0; i < strs[0].length(); i++) {
        //     String searchWord = strs[0].substring(0, i + 1);
        //     for (int j = 1; j < strs.length; j++)
        //         if (strs[j].indexOf(searchWord) != 0)
        //             return prefix;
        //     prefix = searchWord;
        // }
        // return prefix;
        
        // // horizatonal scanning
        // String prefix = strs[0];
        // for (int i = 1; i < strs.length; i++)      
        //     while (strs[i].indexOf(prefix) != 0) {
        //         prefix = strs[0].substring(0, prefix.length() - 1);
        //         if (prefix.length() == 0) return "";                
        //     }
        // return prefix;
                
        // // divide and conquer
        // return longestCommonPrefix(strs, 0, strs.length - 1);
        
        // // binary search
        // if (strs == null || strs.length == 0)
        // return "";
        // int minLen = Integer.MAX_VALUE;
        // for (String str : strs)
        //     minLen = Math.min(minLen, str.length());
        // int low = 1;
        // int high = minLen;
        // while (low <= high) {
        //     int middle = (low + high) / 2;
        //     if (isCommonPrefix(strs, middle))
        //         low = middle + 1;
        //     else
        //         high = middle - 1;
        // }
        // return strs[0].substring(0, (low + high) / 2);
    }
    
//     private String longestCommonPrefix(String[] strs, int left, int right) {
//         if (left == right) return strs[left];
//         int mid = (left + right) / 2;
//         String leftPart = longestCommonPrefix(strs, left, mid);
//         String rightPart = longestCommonPrefix(strs, mid + 1 , right);
//         return commonPrefix(leftPart, rightPart);
//     }
    
//     private String commonPrefix(String strA, String strB) {
//         int min = Math.min(strA.length(), strB.length());
//         for (int i = 0; i < min; i++) {
//             if (strA.charAt(i) != strB.charAt(i)) {
//                 return strA.substring(0, i);
//             }
//         }
//         return strA.substring(0, min);
//     }
    
//     private boolean isCommonPrefix(String[] strs, int len){
//         String str1 = strs[0].substring(0,len);
//         for (int i = 1; i < strs.length; i++)
//             if (!strs[i].startsWith(str1))
//                 return false;
//         return true;
//     }
}

// 2022-07-18
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // // method 1, horizontal scan, time = O(S), space = O(1), S = all string letters size
        // String prefix = strs[0];
        // for (int i = 1; i < strs.length; i++) {
        //     prefix = commonPrefix(prefix, strs[i]);
        //     if (prefix.length() == 0) break;
        // }
        // return prefix;

        // // method 2, vertical scan, time = O(S), space = O(1), S = all string letters size
        // for (int i = 0; i < strs[0].length(); i++) {
        //     char curLetter = strs[0].charAt(i);
        //     for (int j = 1; j < strs.length; j++) {
        //         if (i >= strs[j].length() || curLetter != strs[j].charAt(i)) return strs[0].substring(0, i); 
        //     }
        // }
        // return strs[0];
        
        // // method 3, divide and conquer, time = O(S), space = O(MlogN), S = all string letters size, N = strings count, M = string length
        // return dcCommonPrefix(strs, 0, strs.length - 1);
        
        // method 4, binary search, time = O(SlogM), space = O(1), S = all string letters size, N = strings count, M = string length
        int minWordSize = Integer.MAX_VALUE;
        for (String str: strs) 
            minWordSize = Math.min(minWordSize, str.length());
        int low = 0;
        int high = minWordSize - 1;
        String prefix = "";
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean found = true;
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(strs[i - 1].substring(0, mid + 1))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                prefix = strs[0].substring(0, mid + 1);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return prefix;
    }
    
    // private String dcCommonPrefix(String[] strs, int start, int end) {
    //     if (start == end) return strs[start]; 
    //     int mid = (start + end) / 2;
    //     String leftCommonPrefix = dcCommonPrefix(strs, start, mid);
    //     String rightCommonPrefix = dcCommonPrefix(strs, mid + 1, end);
    //     String prefix = commonPrefix(leftCommonPrefix, rightCommonPrefix);
    //     return prefix;
    // }
    
    // private String commonPrefix(String s1, String s2) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0, j = 0; i < s1.length() && j < s2.length(); ) {
    //         char letter = s1.charAt(i);
    //         if (letter != s2.charAt(j)) return sb.toString();
    //         sb.append(letter);
    //         i++; j++;
    //     }
    //     return sb.toString();
    // }
}