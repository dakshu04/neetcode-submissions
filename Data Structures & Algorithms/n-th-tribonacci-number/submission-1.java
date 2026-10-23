class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fun(n, dp);
    }
    public int fun(int idx, int[] dp) {
        if(idx == 0) return 0;
        if(idx == 1 || idx == 2) return 1;
        if(dp[idx] != -1) {
            return dp[idx];
        }
        dp[idx] = fun(idx - 1, dp) + fun(idx - 2, dp) + fun(idx - 3, dp);
        return dp[idx];
    }
}