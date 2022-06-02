class Solution {
    // // method 1, every cell DFS search
    // public void solve(char[][] board) {
    //     int rowSize = board.length;
    //     int colSize = board[0].length;
    //     // record cell status: 0 = not processed, 1 = not surrounded, 2 = surrounded
    //     boolean[][] processedtable = new boolean[rowSize][colSize];
    //     for (int row = 0; row < rowSize; row++) {
    //         for (int col = 0; col < colSize; col++) {
    //            // pass the cell 
    //            if (board[row][col] == 'X' || processedtable[row][col]) continue;            
    //            else {
    //                // record which cell already computed
    //                int[][] computedTable = new int[rowSize][colSize];
    //                List<Integer> cellRowList = new ArrayList();
    //                List<Integer> cellColList = new ArrayList();
    //                if(!checkNotSurrounded(board, computedTable, row, col, cellRowList, cellColList)) 
    //                    // fill cell with 'X'
    //                    for (int i = 0; i < cellRowList.size(); i++) 
    //                        board[cellRowList.get(i)][cellColList.get(i)] = 'X';
    //                for (int i = 0; i < cellRowList.size(); i++) 
    //                        processedtable[cellRowList.get(i)][cellColList.get(i)] = true;
    //            }
    //         }
    //     }
    // }
    
    // private boolean checkNotSurrounded(char[][] board, int[][] table, int row, int col, List<Integer> cellRowList, List<Integer> cellColList) {
    //     // already computed or 'X' cell
    //     if (table[row][col] == 1 || board[row][col] == 'X') return false;        
    //     // store path
    //     cellRowList.add(row);
    //     cellColList.add(col);
    //     // computed store
    //     table[row][col] = 1;
    //     // check border
    //     if (board[row][col] == 'O' && (row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1)) return true;
    //     // cehck top, right, bottom, left
    //     return checkNotSurrounded(board, table, row - 1, col, cellRowList, cellColList) 
    //         || checkNotSurrounded(board, table, row, col + 1, cellRowList, cellColList) 
    //         || checkNotSurrounded(board, table, row + 1, col, cellRowList, cellColList)
    //         || checkNotSurrounded(board, table, row, col - 1, cellRowList, cellColList);        
    // }

    // method 2, only boundary DFS search
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O')
                boundaryDFS(board, row, 0);
            if (board[row][n - 1] == 'O')
                boundaryDFS(board, row, n - 1); 
        }
        //Start from first and last row, turn '0' to '*'
        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O')
                boundaryDFS(board, 0, col);
            if (board[m - 1][col] == 'O')
                boundaryDFS(board, m - 1, col); 
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 'O')
                    board[row][col] = 'X';
                else if (board[row][col] == '*')
                    board[row][col] = 'O';
            }
        }
    }

    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void boundaryDFS(char[][] board, int row, int col) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1)
            return;
        if (board[row][col] == 'O')
            board[row][col] = '*';
        if (row > 1 && board[row - 1][col] == 'O')
            boundaryDFS(board, row - 1, col);
        if (row < board.length - 2 && board[row + 1][col] == 'O')
            boundaryDFS(board, row + 1, col);
        if (col > 1 && board[row][col - 1] == 'O')
            boundaryDFS(board, row, col - 1);
        if (col < board[row].length - 2 && board[row][col + 1] == 'O' )
            boundaryDFS(board, row, col + 1);
    }
}