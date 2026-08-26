class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, curr, ans, candidates, target);
        return ans;
    }
    public void backtrack(int idx, List<Integer> curr, List<List<Integer>> ans, int[] candidates, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i < candidates.length; i++) {
            // skip duplicates
            if(i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if(candidates[i] > target) {
                break;
            }
            curr.add(candidates[i]);
            backtrack(i + 1, curr, ans, candidates, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
