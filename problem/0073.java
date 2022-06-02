class Solution {
    public void setZeroes(int[][] matrix) {
        // // method 1, space(m+n)
        // Set<Integer> rowSet = new HashSet();
        // Set<Integer> colSet = new HashSet();
        // for (int row = 0; row < matrix.length; row++) {
        //     for (int col = 0; col < matrix[0].length; col++) {
        //         if (matrix[row][col] == 0) {
        //             rowSet.add(row);
        //             colSet.add(col);
        //         }
        //     }
        // }
        // for (int row = 0; row < matrix.length; row++) {
        //     for (int col = 0; col < matrix[0].length; col++) {
        //         if (rowSet.contains(row) || colSet.contains(col)) {
        //             matrix[row][col] = 0;
        //         }
        //     }
        // }
        
        // method 2, space(1)
        boolean isHorizontalZero = false;
        boolean isVerticalZero = false;        
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (col == 0 && matrix[row][0] == 0) isVerticalZero = true;
                if (row == 0 && matrix[0][col] == 0) isHorizontalZero = true;                
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        for (int row = 1; row < matrix.length; row++)
            for (int col = 1; col < matrix[0].length; col++)
                if (matrix[0][col] == 0 || matrix[row][0] == 0)
                    matrix[row][col] = 0;
        for (int row = 1; row < matrix.length; row++) 
            if (isVerticalZero) 
                matrix[row][0] = 0;
        for (int col = 1; col < matrix[0].length; col++) 
            if (isHorizontalZero) 
                matrix[0][col] = 0;
    }
}