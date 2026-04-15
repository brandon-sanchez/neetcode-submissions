class Solution {
    public int trap(int[] height) {
        
        int result = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        while(left < right) {
            if(leftMax <= rightMax) {
                left++;

                leftMax = Math.max(leftMax, height[left]);

                result += leftMax - height[left];
            } else {
                right--;

                rightMax = Math.max(rightMax, height[right]);

                result += rightMax - height[right];
            }
        }

        return result;
    }
}
