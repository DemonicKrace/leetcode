class Solution {
    public boolean isSubsequence(String s, String t) {        
        // // method 1, top down
        // if (s.length() == 0) return true;        
        // int i = t.indexOf(s.charAt(0));
        // if (i >= 0 && isSubsequence(s.substring(1), t.substring(i + 1))) return true;
        // return false;
        
        // // two pointer
        // int pos = 0, sLen = s.length();
        // for (int i = 0; i < t.length(); i++)
        //     if (sLen > 0 && pos < sLen && s.charAt(pos) == t.charAt(i)) pos++; 
        // return sLen == pos;
    }
}