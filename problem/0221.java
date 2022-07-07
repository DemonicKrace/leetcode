class Solution {
    public int maximalSquare(char[][] matrix) {
        // // method 1, brute force
        // int maxArea = 0;
        // int row = matrix.length;
        // int col = matrix[0].length;
        // for (int r = 0; r < row; r++) {
        //     for (int c = 0; c < col; c++) {
        //         if (matrix[r][c] == '0' ) continue;
        //         maxArea = Math.max(maxArea, 1);
        //         int maxBorderLen = Math.min(row - r, col - c);
        //         boolean isSquare = true;
        //         // check border 1 to maxBorderLen
        //         for (int expandLen = 1; expandLen < maxBorderLen; expandLen++) {
        //             // check bottom border
        //             for (int curCol = c; curCol <= c + expandLen; curCol++)
        //                 if (matrix[r + expandLen][curCol] == '0') {
        //                     isSquare = false;
        //                     break;
        //                 }
        //             if (!isSquare) break;
        //             // check right border
        //             for (int curRow = r; curRow <= r + expandLen; curRow++)
        //                 if (matrix[curRow][c + expandLen] == '0') {
        //                     isSquare = false;
        //                     break;
        //                 }
        //             if (isSquare) {
        //                 maxArea = Math.max(maxArea, (expandLen + 1) * (expandLen + 1));
        //             }
        //         } 
        //     }
        // }
        // return maxArea;
        
        // // method 2, dp, time = O(N^2), space = O(N^2)
        // int maxArea = 0;
        // int row = matrix.length;
        // int col = matrix[0].length;
        // int maxSide = Math.min(row, col);
        // int[][] dp = new int[row][col];
        // for (int r = 0; r < row; r++) {
        //     for (int c = 0; c < col; c++) {
        //         // current cell init
        //         if (matrix[r][c] == '1') dp[r][c] = 1;
        //         // not [left, top] border, [current cell, prev top, prev left cell] all greater than zero
        //         if (r != 0 && c != 0 && dp[r][c] > 0 && dp[r - 1][c] > 0 && dp[r][c - 1] > 0 && dp[r - 1][c - 1] > 0) {
        //             // get min side + 1 
        //             dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
        //         }
        //         maxArea = Math.max(maxArea, dp[r][c] * dp[r][c]);
        //         // find max square, return result immediately
        //         if (maxArea == maxSide * maxSide) return maxArea;
        //     }
        // }
        // return maxArea;
        
        // method 3, dp, time = O(N^2), space = O(N)
        int maxSide = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col + 1];
        // store left-top cell result
        int prev = 0;
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                // store top last result
                int temp = dp[c];
                if (matrix[r - 1][c - 1] == '1') {
                    dp[c] = Math.min(Math.min(dp[c], dp[c - 1]), prev) + 1;
                    maxSide = Math.max(maxSide, dp[c]);
                } else {
                    dp[c] = 0;
                }
                // after current cell result computed, next round "top" last result will become "left-top" last result
                prev = temp;
            }
        }
        return maxSide * maxSide;
    }
}