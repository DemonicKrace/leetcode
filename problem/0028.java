class Solution {
    public int strStr(String haystack, String needle) {
        // method 1, KMP, time = O(N), space = O(N)
        int[] kmpTable = computeKMPTable(needle);
        int i = 0, n = haystack.length();
        int j = 0, m = needle.length();
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
                if (j == m) return i - m; 
            }
            else if (j > 0) j = kmpTable[j - 1];
            else i++;
        }
        return -1;
    }
    
    private int[] computeKMPTable(String needle) {
        int n = needle.length();
        int[] kmpTable = new int[n];
        int i = 0, j = 1;
        while (j < n) {
            if (needle.charAt(i) == needle.charAt(j)) kmpTable[j++] = ++i;
            else if (i > 0) i = kmpTable[i - 1];
            else j++;
        }
        return kmpTable;
    }
}