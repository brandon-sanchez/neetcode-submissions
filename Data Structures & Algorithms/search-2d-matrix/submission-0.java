class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //Number of Rows
        int ROWS = matrix.length;

        // Number of Columns
        int COLS = matrix[0].length;

        int left = 0;
        int right = ROWS * COLS - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int row = mid / COLS;
            int col = mid % COLS;

            if(target > matrix[row][col]) {
                left = mid + 1;
            } else if (target < matrix[row][col]) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
