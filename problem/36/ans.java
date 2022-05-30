class Solution {
    public boolean isValidSudoku(char[][] board) {
        // // method 1, brute
        // for (int row = 0; row < board.length; row++)
        //     for (int col = 0; col < board[0].length; col++) {
        //         if (board[row][col] == '.') continue;
        //         char num = board[row][col];
        //         board[row][col] = '.';
        //         if (!check(board, row, col, num)) return false;
        //         board[row][col] = num;
        //     }
        // return true;
        
        // // method 2, dp
        // Set seen = new HashSet();
        // for (int row = 0; row < board.length; row++)
        //     for (int col = 0; col < board[0].length; col++) {
        //         if (board[row][col] == '.') continue;
        //         String rowRecord = String.format("(%s)%s", row, board[row][col]);
        //         String colRecord = String.format("[%s]%s", col, board[row][col]);
        //         String squareRecord = String.format("{%s}%s", (row / 3 * 3 + col / 3 + 1), board[row][col]);
        //         if (!seen.add(rowRecord)) return false;
        //         if (!seen.add(colRecord)) return false;
        //         if (!seen.add(squareRecord)) return false;
        //     }
        // return true;
        
        // // method 2.1, dp
        // Set seen = new HashSet();
        // for (int i=0; i<9; ++i) {
        //     for (int j=0; j<9; ++j) {
        //         if (board[i][j] != '.') {
        //             String b = "(" + board[i][j] + ")";
        //             if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
        //                 return false;
        //         }
        //     }
        // }
        // return true;
        
        // // method 2.2, dp with bitmask
        int N = 9;
        int[] rows = new int[N], cols = new int[N], squares = new int[N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == '.') continue;
                int val = board[r][c] - '0';
                int sPos = (r / 3) * 3 + (c / 3);
                if (getBit(rows[r], val) == 1 || getBit(cols[c], val) == 1 || getBit(squares[sPos], val) == 1)
                    return false;
                rows[r] |= 1 << val;
                cols[c] |= 1 << val;
                squares[sPos] |= 1 << val;
            }
        }
        return true;
        
    }
    
    int getBit(int x, int k) {
        return (x >> k) & 1;
    }
    
    // private boolean check(char[][] board, int row, int col, char num) {
    //     for (int i = 0; i < 9; i++) {
    //         if (board[i][col] == num || board[row][i] == num) return false;
    //         if (board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == num) return false;
    //     }
    //     return true;
    // }
    
}