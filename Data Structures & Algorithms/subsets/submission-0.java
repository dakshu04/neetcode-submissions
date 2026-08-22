class Solution {
    public void backtrack(int idx, List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        backtrack(idx + 1, curr, ans, nums);
        curr.remove(curr.size() - 1);
        backtrack(idx + 1, curr, ans, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, list, ans, nums);
        return ans;
    }
}