class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            System.out.println("-------");
            int mid = left + (right - left) / 2;
            System.out.println("left = " + nums[left]);
            System.out.println("mid = " + nums[mid]);
            System.out.println("right = " + nums[right]);

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
