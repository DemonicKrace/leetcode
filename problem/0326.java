class Solution {
    public boolean isPowerOfThree(int n) {
        // // method 1, precomputation, put 3^0 ~ 3^19 and check
        // Set<Integer> set = new HashSet();
        // int base = 3;
        // for (int i = 0; i < 20; i++) 
        //     set.add((int)Math.pow(base, i));
        // return set.contains(n);
        
        // // method 2, precomputation, time = O(logN), space = (logN), if N is infinite
        // Set<Integer> threeExpSet = new HashSet();
        // for (int i = 0, base = 0; base < Integer.MAX_VALUE / 3; i++) {
        //     base = (int)Math.pow(3, i);
        //     threeExpSet.add(base);
        // }
        // return threeExpSet.contains(n);

        // method 3, math, 3^19 < 2^31 -1 < 3^20, time = O(1), space = (1),
        return n > 0 && ((int)Math.pow(3, 19)) % n == 0;

        // method 4, recursive, time = O(logN), space = (logN)
        return isPowerOfThreeRecur(n);
    }

    private boolean isPowerOfThreeRecur(int n) {
        if (n == 1 || n == 3) return true;
        if (n % 3 != 0 || n == 0) return false;
        return isPowerOfThreeRecur(n / 3);
    }
}