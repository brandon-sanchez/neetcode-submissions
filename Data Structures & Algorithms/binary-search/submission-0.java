class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midpoint = (left + right) / 2;
            if(nums[midpoint] > target) {
                right = midpoint - 1;
            } else if (nums[midpoint] < target) {
                left = midpoint + 1;
            } else {
                return midpoint;
            }
        }

        return -1;
    }
}
