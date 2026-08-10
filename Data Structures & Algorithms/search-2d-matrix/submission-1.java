class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int end = n * m - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            // find the row 
            int row = mid / m;
            // find the col
            int col = mid % m;
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
