class Solution {
    public int firstUniqChar(String s) {
        // method 1
        // // index = letter ascii offset, value = appear count
        // int[] letter = new int['z' - 'a' + 1];
        // // index = s index, value = letter index
        // int[] position = new int[s.length()];
        // // compute every letter appear count 
        // for (int i = 0; i < s.length(); i++) {
        //     int index = s.charAt(i) - 'a';
        //     position[i] = index;
        //     letter[index]++;
        // }
        // for (int i = 0; i < s.length(); i++) 
        //     if (letter[position[i]] == 1) 
        //         return i;
        // return -1;
        
        // // method 2, use map to store, T = O(N), S = O(1)
        // Map<Character, Integer> count = new HashMap();
        // int n = s.length();
        // // build hash map : character and how often it appears
        // for (int i = 0; i < n; i++) {
        //     char c = s.charAt(i);
        //     count.put(c, count.getOrDefault(c, 0) + 1);
        // }
        // // find the index which is first single letter
        // for (int i = 0; i < n; i++) {
        //     if (count.get(s.charAt(i)) == 1)
        //         return i;
        // }
        // return -1;

        // method 3, use array to store, time = O(N), space = O(1)
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) if (count[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }
}