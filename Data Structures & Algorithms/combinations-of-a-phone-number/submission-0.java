class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapping = { 
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz" 
        };
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;
        StringBuilder strB = new StringBuilder();
        backtrack(0, strB, ans, digits, mapping);
        return ans;
    }
    public void backtrack(int idx, StringBuilder strB, List<String> ans, String digits, String[] mapping) {
        if(idx >= digits.length()) {
            ans.add(strB.toString());
            return;
        }
        int number = digits.charAt(idx) - '0';
        String value = mapping[number];

        for (int i = 0; i < value.length(); i++) {
            strB.append(value.charAt(i));
            backtrack(idx + 1, strB, ans, digits, mapping);
            // Backtracking step
            strB.deleteCharAt(strB.length() - 1);
        }
    }
}
