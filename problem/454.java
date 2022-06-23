class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> count = new HashMap();
        for (int n1: nums1) {
            for (int n2: nums2) {
                count.put(n1 + n2, count.getOrDefault(n1 + n2, 0) + 1);
            }
        }
        int sum = 0;
        for (int n3: nums3) {
            for (int n4: nums4) {
                sum += count.getOrDefault(-n3 - n4, 0);
            }
        }
        return sum;
    }
}