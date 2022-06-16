class Solution {
    public boolean isPowerOfThree(int n) {
        // // method 1, put 3^0 ~ 3^19 and check
        // Set<Integer> set = new HashSet();
        // int base = 3;
        // for (int i = 0; i < 20; i++) 
        //     set.add((int)Math.pow(base, i));
        // return set.contains(n);
        
        // method 2, 3^19 < 2^31 -1 < 3^20
        return n > 0 && ((int)Math.pow(3, 19)) % n == 0;
    }
}