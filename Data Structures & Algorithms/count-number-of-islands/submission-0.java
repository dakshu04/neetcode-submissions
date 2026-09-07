class Solution {
    public void dfs(int row, int col, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // Boundary checks and visited check
        if (row < 0 || col < 0 || row >= n || col >= m || grid[row][col] == '0') {
            return;
        }
        // Mark this cell as visited
        grid[row][col] = '0';
        // Move in 4 directions
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            dfs(nrow, ncol, grid);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int numberOfIslands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    dfs(i, j, grid);
                }
            }
        }
        return numberOfIslands;
    }
}
