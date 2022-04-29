class Solution {
    // // <h, <w, [square1, square2, square3, ...]>>
    // Map<Integer, Map<Integer, List<Boolean>>> log = new HashMap();
    
    public int countSquares(int[][] matrix) {
        // // method 1, brute
        // int height = matrix.length;
        // int width = matrix[0].length;
        // int sum = 0;
        // for (int side = 1; side <= Math.max(height, width); side++) {
        //     sum += getSquareCount(matrix, 0, height, 0, width, side);
        // }
        // return sum;        
        
        // // method 2, part dp
        // int height = matrix.length;
        // int width = matrix[0].length;
        // int[][] dp = new int[height][width];
        // for (int h = 0; h < height; h++) {
        //     for (int w = 0; w < width; w++) {
        //         if (h == 0 || w == 0) 
        //             dp[h][w] = dp[h > 1 ? h - 1: 0][w > 1 ? w - 1: 0] + getFixedCount(matrix, h, w, 1);
        //         else {
        //             int side = Math.min(h + 1, w + 1);                    
        //             dp[h][w] = dp[h][w - 1] + dp[h - 1][w] - dp[h - 1][w - 1] + getFixedCount(matrix, h, w, side);
        //         }
        //     }
        // }
        // return dp[height - 1][width - 1];
        
        // https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-%2B-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space)
        // method 3, best dp way
        int res = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                res += matrix[i][j];
            }
        }
        return res;
    }
    
    // int getFixedCount(int[][] matrix, int hPos, int wPos, int side) {
    //     int sum = 0;
    //     boolean isCornerSquare = true, isHeightLineAllOne = true, isWidthLineAllOne = true;
    //     List<Boolean> temp = new ArrayList<Boolean>();
    //     // check corner
    //     if (matrix[hPos][wPos] == 0) isCornerSquare = false;
    //     else sum++;
    //     temp.add(isCornerSquare);
    //     for (int curSide = 1; curSide < side; curSide++) {
    //         boolean isSquare = false;
    //         boolean isPreCornerSquare = log.get(hPos - 1).get(wPos - 1).get(curSide - 1);
    //         if (isPreCornerSquare && isCornerSquare) {
    //             // check vertical line
    //             boolean isVerticalOne = true;
    //             for (int startW = wPos - 1; startW > wPos - 1 - curSide; startW--) {
    //                 if (matrix[hPos][startW] == 0) {
    //                     isVerticalOne = false;
    //                     break;
    //                 }
    //             }
    //             // check horizationl line
    //             boolean isHorizationlOne = true;
    //             for (int startH = hPos - 1; startH > hPos - 1 - curSide; startH--) {
    //                 if (matrix[startH][wPos] == 0) { 
    //                     isHorizationlOne = false;
    //                     break;
    //                 }
    //             }
    //             if (isVerticalOne && isHorizationlOne) {
    //                 isSquare = true;
    //             }
    //         }
    //         temp.add(isSquare);
    //         if (isSquare) sum++;
    //     }
    //     if (!log.containsKey(hPos))
    //         log.put(hPos, new HashMap());
    //     if (!log.get(hPos).containsKey(wPos))
    //         log.get(hPos).put(wPos, temp);        
    //     return sum;
    // }
    
    // int getSquareCount(int[][] matrix, int sHeight, int eHeight, int sWidth, int eWidth, int sideLength) {
    //     int count = 0;
    //     for (int x = sWidth; x < eWidth; x++) {
    //         if (x + sideLength > eWidth) break;
    //         for (int y = sHeight; y < eHeight; y++) {
    //             if (y + sideLength > eHeight) break;
    //             boolean isSquare = true;
    //             for (int sX = x; sX < x + sideLength; sX++) {
    //                 for (int sY = y; sY < y + sideLength; sY++) {
    //                     if (matrix[sY][sX] != 1) {
    //                         isSquare = false;
    //                         break;
    //                     }
    //                 }
    //                 if (!isSquare) break;
    //             }
    //             if (isSquare) count++;
    //         }
    //     }
    //     return count;
    // }
}