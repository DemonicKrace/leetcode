class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // // method 1, brute, time limit exceeded
        // for (int i = 0; i < gas.length; i++)
        //     if (check(gas, cost, i)) return i;
        // return -1;
        
        // // method 2
        // // iterate station from index 0
        // int len = gas.length;
        // int totalGas = 0;
        // for (int pos = 0; pos < len; pos++) {
        //     if (gas[pos] - cost[pos] < 0) continue;
        //     int remainGas = 0;
        //     // try a round
        //     for (int start = pos; start < pos + len; start++) {
        //         int curPos = start % len;
        //         remainGas += gas[curPos] - cost[curPos];                                        
        //         totalGas += remainGas;
        //         if (remainGas < 0) {
        //             // move to last position
        //             pos = start;
        //             break;
        //         }
        //         if (totalGas < 0 && pos == len) return -1;
        //     }
        //     if (remainGas >= 0) return pos;
        // }
        // return -1;
            
        // // method 3, method 2 with dp 
        // // dp, startPos => [endPos, remainGas]
        // Map<Integer, List<Integer>> lack = new HashMap();
        // // iterate station from index 0
        // for (int pos = 0; pos < gas.length; pos++) {
        //     int remainGas = 0;
        //     if (gas[pos] - cost[pos] < 0) continue;
        //     // try a round
        //     for (int start = pos; start < pos + gas.length; start++) {
        //         int curPos = start % gas.length;                
        //         if (lack.containsKey(curPos)) {
        //             int endPos = lack.get(curPos).get(0);
        //             int lackGas = lack.get(curPos).get(1);
        //             remainGas += lackGas;
        //             start += endPos- curPos;
        //             // move curPos to endPos
        //             curPos = endPos;
        //             // set next round
        //         } else remainGas += gas[curPos] - cost[curPos];                                        
        //         if (remainGas < 0) {
        //             lack.put(pos, Arrays.asList(curPos, remainGas));
        //             // move to last position
        //             pos = start;
        //             break;
        //         }
        //     }
        //     if (remainGas >= 0) return pos;
        // }
        // return -1;
        
        // // method 4, pass as one iteration, best way
        // // https://leetcode.com/problems/gas-station/discuss/1706142/JavaC%2B%2BPython-An-explanation-that-ever-EXISTS-till-now!!!!
        // int n = gas.length;
        // int total_surplus = 0;
        // int surplus = 0;
        // int start = 0;        
        // for(int i = 0; i < n; i++){
        //     total_surplus += gas[i] - cost[i];
        //     surplus += gas[i] - cost[i];
        //     if(surplus < 0){
        //         surplus = 0;
        //         start = i + 1;
        //     }
        // }
        // return (total_surplus < 0) ? -1 : start;
    }
    
    // private boolean check(int[] gas, int[] cos, int start) {
    //     int curGas = gas[start], len = gas.length;
    //     for (int i = 1; i <= len; i++) {
    //         // move cost
    //         curGas = curGas - cos[(start + i - 1) % len];
    //         // check gas enough
    //         if (curGas < 0) return false;
    //         // add station gas
    //         curGas += gas[(start + i) % len];
    //     }
    //     return true;
    // }
}