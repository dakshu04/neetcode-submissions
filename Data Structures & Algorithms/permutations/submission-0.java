class Solution {
    public void backtrack(int idx, int[] nums, List<List<Integer>> ans) {
        if(idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums) {
                list.add(num);
            }
            ans.add(new ArrayList<>(list));
        }
        for(int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            backtrack(idx + 1,nums, ans);
            swap(nums, i, idx);
        }
    }
    public void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, ans);
        return ans;
    }
}
