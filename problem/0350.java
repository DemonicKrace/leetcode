class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // // method 1
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // int n1Size = nums1.length, n2Size = nums2.length;
        // List<Integer> res = new ArrayList();
        // int n1 = 0, n2 = 0;
        // while (n1 < n1Size && n2 < n2Size) {
        //     if (nums1[n1] > nums2[n2]) n2++;
        //     else if (nums1[n1] < nums2[n2]) n1++;
        //     else {
        //         res.add(nums1[n1]);
        //         n1++;
        //         n2++;
        //     }
        // }
        // return res.stream().mapToInt(i -> i).toArray();
                
        // mehtod 2, use map to store number count
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1)
            map.put(i, map.getOrDefault(i, 0) + 1);
        ArrayList<Integer> list = new ArrayList();
        for(int i : nums2)
            if(map.getOrDefault(i, 0) > 0){
                list.add(i);
                map.put(i, map.getOrDefault(i, 0) - 1);
            }        
        int[] ret = new int[list.size()]; 
        for(int i = 0; i < list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }
}