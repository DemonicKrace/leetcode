class Solution {
    public void gameOfLife(int[][] board) {
        
        // // method 1, brute 
        // int[][] temp = new int[board.length][board[0].length];
        // for (int i = 0; i < board.length; i++) 
        //     for (int j = 0; j < board[0].length; j++)
        //         computeCell(temp, board, i, j);
        // for (int i = 0; i < board.length; i++) 
        //     for (int j = 0; j < board[0].length; j++)
        //         board[i][j] = temp[i][j];
        
        // method 2, in place
        // cell: {next:bit}{current:bit}, ex: 01 -> next(0) cureent(1)
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                for (int row = Math.max(i - 1, 0); row < Math.min(i + 2, board.length); row++)
                    for (int col = Math.max(j - 1, 0); col < Math.min(j + 2, board[0].length); col++)
                        if (row == i && col == j) continue;
                        else if ((board[row][col] & 1) == 1) live++;
                // 11
                if ((board[i][j] & 1) == 1 && (live == 2 || live == 3)) board[i][j] = 3;
                // 10
                else if ((board[i][j] & 0) == 0 && live == 3) board[i][j] = 2;
            }
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[0].length; j++)
                board[i][j] >>= 1;
    }
    
    // private void computeCell(int[][] temp, int[][] board, int row, int col) {
    //     int live = 0;
    //     int dead = 0;
    //     for (int r = row - 1; r < row + 2; r++) {
    //         if (r < 0 || r >= board.length) continue;
    //         for (int c = col - 1; c < col + 2; c++) {
    //             if (c < 0 || c >= board[0].length || (r == row && c == col)) continue; 
    //             if (board[r][c] == 1) live++;
    //             else dead++;
    //         }
    //     }
    //     // rule 1
    //     if (board[row][col] == 1 && live < 2) temp[row][col] = 0;
    //     // rule 2
    //     else if (board[row][col] == 1 && (live == 2 || live == 3)) temp[row][col] = 1;
    //     // rule 3
    //     else if (board[row][col] == 1 && live > 3) temp[row][col] = 0;
    //     // rule 4
    //     else if (board[row][col] == 0 && live == 3) temp[row][col] = 1;
    //     // System.out.printf("(%d, %d) l=%d d=%d\n", row, col, live, dead);
    // }
}