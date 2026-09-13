class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder strB = new StringBuilder();

        backtrack(0, 0, n, strB, res);
        return res;
    }

    private void backtrack(int openN, int closedN, int n, StringBuilder strB, List<String> res) {
        // Base case: valid combination found
        if (openN == n && closedN == n) {
            res.add(strB.toString());
            return;
        }

        // Only add an open parenthesis if openN < n
        if (openN < n) {
            strB.append("(");
            backtrack(openN + 1, closedN, n, strB, res);
            strB.deleteCharAt(strB.length() - 1); // backtrack / pop
        }

        // Only add a closing parenthesis if closedN < openN
        if (closedN < openN) {
            strB.append(")");
            backtrack(openN, closedN + 1, n, strB, res);
            strB.deleteCharAt(strB.length() - 1); // backtrack / pop
        }
    }
}