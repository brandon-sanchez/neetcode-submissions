public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        // Step 1: Binary Search to find the correct row
        int top = 0;
        int bot = ROWS - 1;

        while (top <= bot) {
            // Look at the middle row
            int row = (top + bot) / 2;

            // If the target is greater than the last value in this row,
            // then the target must be in a lower row
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;

            // If the target is less than the first value in this row,
            // then the target must be in an upper row
            } else if (target < matrix[row][0]) {
                bot = row - 1;

            // Otherwise, the target must be in this row
            } else {
                break;
            }
        }

        // If we never found a row where the target could be
        if (!(top <= bot)) {
            return false;
        }

        // Set the row to search in
        int row = (top + bot) / 2;

        // Step 2: Binary Search within the row
        int l = 0;
        int r = COLS - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;  // Target found
            }
        }

        return false;  // Target not found
    }
}
