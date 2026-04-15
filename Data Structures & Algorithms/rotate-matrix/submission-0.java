class Solution {
    public void rotate(int[][] matrix) {
        int left = 0, right = matrix.length - 1;

        while (left < right) {
            for(int i = 0; i < right - left; i++){
                int top = left;
                int bottom = right;

                //Save topLeft value;
                int topLeft = matrix[top][left + i];

                //Move bottom left value into top left
                matrix[top][left + i] = matrix[bottom - i][left];

                //Move bottom right value into bottom left 
                matrix[bottom - i][left] = matrix[bottom][right - i];

                //Move top right value into bottom right
                matrix[bottom][right - i] = matrix[top + i][right];

                //Move top left value into top right
                matrix[top + i][right] = topLeft;
            }
            left++;
            right--;
        }
    }
}
