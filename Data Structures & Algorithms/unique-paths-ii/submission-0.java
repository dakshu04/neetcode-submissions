class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(m - 1, n - 1, obstacleGrid, dp);
    }

    private int solve(int i, int j, int[][] grid, int[][] dp) {

        // If out of bounds, no valid path
        if (i < 0 || j < 0) {
            return 0;
        }

        // If the cell contains an obstacle, no valid path
        if (grid[i][j] == 1) {
            return 0;
        }

        // Base case: reached the starting cell
        if (i == 0 && j == 0) {
            return 1;
        }

        // Return the previously calculated result
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move up
        int up = solve(i - 1, j, grid, dp);

        // Move left
        int left = solve(i, j - 1, grid, dp);

        // Total paths = paths from up + paths from left
        return dp[i][j] = up + left;
    }
}