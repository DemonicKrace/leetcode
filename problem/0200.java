class Solution {
    public int numIslands(char[][] grid) {
        // // method 1, DFS recursive, time = O(N), space = O(N), N = grid cells size
        // int count = 0;
        // int rows = grid.length;
        // int cols = grid[0].length;
        // boolean[][] visited = new boolean[rows][cols];
        // for (int r = 0; r < rows; r++) {
        //     for (int c = 0; c < cols; c++) {
        //         if (!visited[r][c] && grid[r][c] == '1') {
        //             count++;
        //             dfsTraversal(grid, r, c, visited);
        //         }
        //     }
        // }
        // return count;
        
        // method 2, BFS with queue to iterate, time = O(N), space = O(N), N = grid cells size
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && grid[r][c] == '1') {
                    count++;
                    Deque<Pair<Integer, Integer>> queue = new ArrayDeque();
                    queue.add(new Pair(r, c));
                    while (!queue.isEmpty()) {
                        Pair<Integer, Integer> cur = queue.poll();
                        int curRow = cur.getKey(), curCol = cur.getValue();
                        if (visited[curRow][curCol]) continue;
                        visited[curRow][curCol] = true;
                        if (grid[curRow][curCol] == '0') continue;
                        if (curRow - 1 >= 0) queue.add(new Pair(curRow - 1, curCol));
                        if (curCol + 1 < cols) queue.add(new Pair(curRow, curCol + 1));
                        if (curRow + 1 < rows) queue.add(new Pair(curRow + 1, curCol));
                        if (curCol - 1 >= 0) queue.add(new Pair(curRow, curCol - 1));
                    }
                }
            }
        }
        return count;       
    }
    
    private void dfsTraversal(char[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c]) return;
        visited[r][c] = true;
        if (grid[r][c] == '0') return;
        dfsTraversal(grid, r - 1, c, visited);
        dfsTraversal(grid, r, c + 1, visited);
        dfsTraversal(grid, r + 1, c, visited);
        dfsTraversal(grid, r, c - 1, visited);
    }
}