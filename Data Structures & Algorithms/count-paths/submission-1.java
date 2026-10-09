class Solution {
    public int fun(int idx1, int idx2, int[][] dp, int m, int n) {
        if(idx1 >= m || idx2 >= n) return 0;
        if(idx1 == m - 1 && idx2 == n - 1) return 1;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int down = fun(idx1 + 1, idx2, dp, m, n);
        int right = fun(idx1, idx2 + 1, dp, m, n);
        return dp[idx1][idx2] = down + right;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
       return fun(0, 0, dp, m, n); 
    }
}
