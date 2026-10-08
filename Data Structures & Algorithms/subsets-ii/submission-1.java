class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}
    public void backtrack(int idx, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(current));

        for (int i = idx; i < nums.length; i++) {

            // Skip duplicate choices at the same level
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, current, ans);

            // Undo choice
            current.remove(current.size() - 1);
    }
}
