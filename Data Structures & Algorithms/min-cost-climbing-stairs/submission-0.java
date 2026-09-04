class Solution {
    public int helperFn(int[] cost, int idx, int[] dp) {
        if (idx == 0 || idx == 1) return cost[idx];
        if (dp[idx] != -1) return dp[idx];
        
        int left = cost[idx] + helperFn(cost, idx - 1, dp);
        int right = cost[idx] + helperFn(cost, idx - 2, dp);
        return dp[idx] = Math.min(left, right);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(helperFn(cost, n - 1, dp), helperFn(cost, n - 2, dp));
    }
}
