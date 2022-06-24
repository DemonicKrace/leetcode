class Solution {
    public int[] topKFrequent(int[] nums, int k) {    
        // method 1, Time complexity O(n)
        Map<Integer, Integer> map = new HashMap();
        int maxCount = 0;
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            maxCount = Math.max(maxCount, map.get(n));
        }
        int[][] table = new int[maxCount + 1][k];
        int[] storeIndex = new int[maxCount + 1];
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (storeIndex[count] >= k) continue;            
            table[count][storeIndex[count]] = num;
            storeIndex[count]++;
        }
        int[] result = new int[k];
        int count = 0;
        for (int i = maxCount; i >= 0; i--) {
            for (int j = 0; j < storeIndex[i]; j++) {
                result[count] = table[i][j];
                count++;
            }
            if (count >= k) break;
        }
        return result;
    }
}