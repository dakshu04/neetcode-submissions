class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check for row
        for(int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) { // for same row checking each coln
                if(board[row][i] == '.') {
                    continue;
                }
                if(seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }
        for(int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for(int i = 0; i < 9; i++) { // for same coln checking each row
                if(board[i][col] == '.') continue;
                if(seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }
        // checking boxes
        for(int boxes = 0; boxes < 9; boxes++) {
            Set<Character> set = new HashSet<>();
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    int row = (boxes/3)*3 + i;
                    int col = (boxes%3)*3 + j;
                    if(board[row][col] == '.') continue;
                    if(set.contains(board[row][col])) return false;
                    set.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
