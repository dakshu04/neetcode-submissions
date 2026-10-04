class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(fun(nums, dp1, 0, n - 2), fun(nums, dp2, 1, n - 1));
    }
    public int fun(int[] nums, int[] dp, int start, int end) {
        if(start > end) {
            return 0;
        }
        if(dp[start] != -1) {
            return dp[start];
        }
        int stole = nums[start] + fun(nums, dp, start + 2, end);
        int notStole = fun(nums, dp, start + 1, end);
        dp[start] = Math.max(stole, notStole);
        return dp[start];
    }
}