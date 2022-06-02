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