class Solution {
    public int countPrimes(int n) {
        // method 1
        if(n <=1 ) return 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = 2; j * i < n; j++) {
                    notPrime[i * j] = true; 
                }
            }
        }        
        int count = 0; 
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) count++;
        }
        return count;

        // method 2, best way
        if (n < 3) return 0;        
        boolean[] notPrime = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (notPrime[i])
                continue;

            for (int j = i * i; j < n; j += 2 * i) {
                if (!notPrime[j]) {
                    --count;
                    notPrime[j] = true;
                }
            }
        }
        return count;
    }
}

// 25
    
// 2 3 5 7 11 13 17 19 23
    
    
// 1     3     5     7         
// 11    13         17    19  
//       23     
    
// 3  +6
//     9   15  21 
// 5   +10
//     25 (25 < 25, stop)
