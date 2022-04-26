class Solution {
    Boolean[] dp;
    
    public boolean divisorGame(int n) {        
        // // brute, Time Limit Exceeded!
        // for (int i = 1; i < n; i++) {
        //     // check opponent lose
        //     if (n % i == 0 && !divisorGame(n - 1)) {
        //         return true;
        //     }
        // }
        // return false;
        
        // // dp
        // dp = new Boolean[n + 1];
        // // when opponent arrive 0 return fail
        // dp[0] = true;
        // dp[1] = false;
        // return check(n);
        
        // https://leetcode.com/problems/divisor-game/discuss/274606/JavaC%2B%2BPython-return-N-2-0
        // mathematical
        return n % 2 == 0;
    }
    
//     boolean check(int n) {
//         if (dp[n] != null) {
//             return dp[n];
//         }
//         dp[n] = false;
        
//         // // type 1, try all
//         // for (int i = 1; i < n; i++) {
//         //     if (n % i == 0 && !check(n - i)) {
//         //         dp[n] = true;
//         //         break;
//         //     }
//         // }
        
//         // type 2, try a pair, better than type 1.
//         for (int i = 1; i * i <= n; i++) {
//             if (n % i == 0 && (!check(n - i) || !check(n - (n / i)))) {
//                 dp[n] = true;
//                 break;
//             }
//         }        
        
//         return dp[n];
//     }
}


