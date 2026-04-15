class Solution {
    public int findMin(int[] nums) {
        // Initialize the search range: full array
        int left = 0;
        int right = nums.length - 1;

        // Binary search loop: narrow down the range until left == right
        while(left < right) {
            // Calculate the middle index safely to avoid overflow
            int mid = (right + left) / 2;

            // If the mid element is less than the rightmost element,
            // it means the minimum must be in the left half (including mid)
            if(nums[mid] < nums[right]) {
                right = mid;
            } 
            // Otherwise, the minimum is in the right half (excluding mid)
            else {
                left = mid + 1;
            }
        }

        // At the end of the loop, left == right, pointing to the minimum element
        return nums[left];
    }
}
