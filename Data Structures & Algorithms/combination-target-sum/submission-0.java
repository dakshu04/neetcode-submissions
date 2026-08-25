class Solution {
    public void backtrack(int idx, List<Integer> curr, List<List<Integer>> ans, int[] nums, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || idx >= nums.length) {
            return;
        }
        curr.add(nums[idx]);
        backtrack(idx, curr, ans, nums, target - nums[idx]);
        curr.remove(curr.size() - 1);
        backtrack(idx + 1, curr, ans, nums, target);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0, curr, ans, nums, target);
        return ans;
    }
}
