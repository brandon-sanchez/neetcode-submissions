class Solution {
    public int findMin(int[] nums) {
        // Initialize pointers to the start and end of the array
        int left = 0;
        int right = nums.length - 1;

        // Binary search loop continues while the search space is greater than 1 element
        while (left < right) {
            // Compute the midpoint to avoid integer overflow
            int mid = (right + left) / 2;

            /*
             Example: nums = [4,5,6,7,0,1,2]
             First iteration:
             left = 0, right = 6, mid = 3 → nums[3] = 7, nums[6] = 2

             Since nums[mid] > nums[right], we know the smallest value
             must be to the right of mid, so we move left = mid + 1
            */

            if (nums[mid] < nums[right]) {
                // The min is in the left part (including mid), shrink the right bound
                right = mid;

                /*
                 Example: nums = [3,4,5,1,2]
                 left = 0, right = 4, mid = 2 → nums[2] = 5, nums[4] = 2
                 5 > 2 → move left = mid + 1 → left = 3
                */
            } else {
                // The min is in the right part (excluding mid), shrink the left bound
                left = mid + 1;

                /*
                 Example: nums = [4,5,6,7,0,1,2]
                 mid = 3 → nums[3] = 7, nums[6] = 2 → 7 > 2
                 So we know min is to the right of mid → left = mid + 1 = 4
                */
            }
        }

        // After the loop ends, left == right, pointing at the smallest element
        return nums[left];

        /*
         For example: nums = [4,5,6,7,0,1,2]
         After loop:
         left = right = 4 → nums[4] = 0 → that's the smallest element
        */
    }
}
