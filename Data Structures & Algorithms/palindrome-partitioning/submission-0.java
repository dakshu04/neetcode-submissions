class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(0, curr, res, s);
        return res;
    }
    public void backtrack(int idx, List<String> curr, List<List<String>> res, String s) {
        if(idx == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            if(isPalindrome(idx, i, s)) {
                curr.add(s.substring(idx, i + 1));
                backtrack(i + 1, curr, res, s);
                curr.remove(curr.size() - 1);
            }
        }
    }
    private boolean isPalindrome(int start, int end, String s) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
