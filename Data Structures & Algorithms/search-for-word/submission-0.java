class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int row, int col, char[][] board, String word, int idx) {
        if(idx == word.length()) {
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = dfs(row + 1, col, board, word, idx + 1) || dfs(row, col + 1, board, word, idx + 1) || dfs(row - 1, col, board, word, idx + 1) || dfs(row, col - 1, board, word, idx + 1);
        board[row][col] = temp;
        return found;
    }
}
