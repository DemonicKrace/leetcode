class Solution {
    // n's sum
    Map<Integer, Integer> dp = new HashMap(){{put(1, 5); put(2, 15);}};
    // n's ['a', 'e', 'i', 'o', 'u'] each first letter sum
    Map<Integer, List<Integer>> log = new HashMap(){{put(1, Arrays.asList(1, 1, 1, 1, 1)); put(2, Arrays.asList(5, 4, 3, 2, 1));}};
    
    public int countVowelStrings(int n) {
        if(dp.containsKey(n)) return dp.get(n);        
        int sum = 0;
        // first element is previous sum of n - 1
        int logElement = countVowelStrings(n - 1);
        List<Integer> newLog = new ArrayList<Integer>();
        // [a, e, i, o, u] to arrange
        for (int i = 0; i < 5; i++) {
            if (i > 0) {
                logElement -= log.get(n - 1).get(i - 1);
            }
            sum += logElement;
            newLog.add(logElement);
        }
        dp.put(n, sum);
        log.put(n, newLog);
        return dp.get(n);
    }
}