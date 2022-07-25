class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // method 1, sorted letters as key to store strings, time = O(N * KlogK), space = O(N), K = characters size
        Map<String, List<String>> map = new HashMap();
        for (String s : strs) {
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            List<String> list = map.getOrDefault(key, new ArrayList());
            list.add(s);
            map.put(key, list);      
        }
        return new ArrayList(map.values());
    }
}