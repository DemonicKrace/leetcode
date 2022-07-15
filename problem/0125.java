class Solution {
    public boolean isPalindrome(String s) {
        // method 1, two pointer, time = O(N), space = O(1)
        int len = s.length(), left = 0, right = len - 1;
        while (true) {
            while (left < len && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (right >= 0 && !Character.isLetterOrDigit(s.charAt(right))) right--;            
            if (left == len && right < 0) break;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            else { left++; right--;}
        }
        return true;
        
        // // method 2, speed down
        // String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // String rev = new StringBuffer(actual).reverse().toString();
        // return actual.equals(rev);

        // // 2022-07-14
        // int left = 0;
        // int right = s.length() - 1;
        // while (left < right) {
        //     while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
        //     while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
        //     if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
        //     left++;
        //     right--;
        // }
        // return true;
    }
}