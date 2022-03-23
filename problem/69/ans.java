class Solution {
	// solution 1, Binary search - Template #1
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
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
