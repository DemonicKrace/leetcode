class Solution {
    public boolean exist(char[][] board, String word) {
        // method 1, backtrack, time = O(N^2 * 4^M), space = O(4^M), M = word length
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtrack(board, row, col, word, 0, visited)) return true;
            }
        }
        return false;
        
        // // https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space.
        // // bit mask <=> visited table
        // if (i == word.length) return true;
        // if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
        // if (board[y][x] != word[i]) return false;
        // board[y][x] ^= 256;
        // boolean exist = exist(board, y, x+1, word, i+1)
        //     || exist(board, y, x-1, word, i+1)
        //     || exist(board, y+1, x, word, i+1)
        //     || exist(board, y-1, x, word, i+1);
        // board[y][x] ^= 256;
        // return exist;
    }

    // private boolean exist(char[][] board, int y, int x, char[] word, int i) {
    //     if (i == word.length) return true;
    //     if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
    //     if (board[y][x] != word[i]) return false;
    //     board[y][x] ^= 256;
    //     boolean exist = exist(board, y, x+1, word, i+1)
    //         || exist(board, y, x-1, word, i+1)
    //         || exist(board, y+1, x, word, i+1)
    //         || exist(board, y-1, x, word, i+1);
    //     board[y][x] ^= 256;
    //     return exist;
    // }
    
    private boolean backtrack(char[][] board, int row, int col, String word, int index, boolean[][] visited) {
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) return false;
        if (visited[row][col] || board[row][col] != word.charAt(index)) return false;
        if (index == word.length() - 1 && board[row][col] == word.charAt(index)) return true; 
        visited[row][col] = true;
        boolean top = backtrack(board, row - 1, col, word, index + 1, visited);
        boolean right = backtrack(board, row, col + 1, word, index + 1, visited);
        boolean bottom = backtrack(board, row + 1, col, word, index + 1, visited);
        boolean left = backtrack(board, row, col - 1, word, index + 1, visited);
        visited[row][col] = false;        
        return top || right || bottom || left;
    }
    
    // private boolean backtrackCheck(char[][] board, boolean[][] visited, int row, int col, String word, int strIndex) {
    //     // check in border, select not repeated, current cell is match
    //     if (0 <= row && row < board.length && 0 <= col && col < board[0].length && !visited[row][col] && board[row][col] == word.charAt(strIndex)) {
    //         // last letter
    //         if (strIndex == word.length() - 1) return true;
    //         // place in
    //         visited[row][col] = true;  
    //         // keep search
    //         if (backtrackCheck(board, visited, row - 1, col, word, strIndex + 1) || 
    //             backtrackCheck(board, visited, row, col + 1, word, strIndex + 1) ||
    //             backtrackCheck(board, visited, row + 1, col, word, strIndex + 1) ||
    //             backtrackCheck(board, visited, row, col - 1, word, strIndex + 1)) return true;
    //         // remove
    //         visited[row][col] = false;
    //     }
    //     return false;
    // }
}