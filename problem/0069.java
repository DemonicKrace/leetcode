class Solution {
    public int mySqrt(int x) {
        // method 1, Binary search - Template #2, time = O(logN), space O(1)
        if (x == 0) return 0;
        int left = 1, right = x;
        // type2, left <= right
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1 ) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
            	// type2, right = mid - 1;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

        // method 2, Binary search - math, time = O(logN), space O(1)
        if (x == 0) return 0;
        // avoid overflow
        long i = x;
        while(i > x / i) 
            i = (i + x / i) / 2;
        return (int)i;
    }

    // solution 2
    public int mySqrt(int x) {
    	if (x == 0) return 0;
		long i = x;
		while(i > x / i)  
			i = (i + x / i) / 2;
		return (int)i;
	}

	// solution 3, brute force
	// ...

}

// 2022-08-02
class Solution {
    public int mySqrt(int x) {
        // method 1, math, time = O(logN), space O(1)
        int lastBase = 0;
        for (int base = 0; x - base * base >= 0; base++) lastBase = base;
        return lastBase;
    }
}