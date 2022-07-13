class Solution {
    public void rotate(int[][] matrix) {
        // // method 1, move directly, time = O(N^2), space = O(1)
        // int n = matrix.length;
        // for (int row = 0; row < (n + 1) / 2; row++) {
        //     for (int col = 0; col < n / 2; col++) {
        //         int temp = matrix[row][col];
        //         matrix[row][col] = matrix[n - col - 1][row];
        //         matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];
        //         matrix[n - row - 1][n - col - 1] = matrix[col][n - row - 1];
        //         matrix[col][n - row - 1] = temp;
        //     }
        // }
        
        // method 2, transpose and reflect, time = O(N^2), space = O(1)
        transpose(matrix);
        reflect(matrix);
    }
    
    // 1 2    1 3
    // 3 4 -> 2 4
    private void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
    
    // 1 3    3 1
    // 2 4 -> 4 2
    private void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][n - col - 1];
                matrix[row][n - col - 1] = temp;
            }
        }
    }
}