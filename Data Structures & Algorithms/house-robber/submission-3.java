class Solution {
    public int rob(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        return dp(0, nums, arr);
    }
    public int dp(int idx, int[] nums, int[] arr) {
        if(idx >= nums.length) {
            return 0;
        }
        if(arr[idx] != -1) return arr[idx];
        int oneStep = nums[idx] + dp(idx + 2, nums, arr);
        int twoStep = dp(idx + 1, nums, arr);
        return arr[idx] = Math.max(oneStep, twoStep);
    }
}
