class Solution {
    public int trap(int[] height) {
        
        //If the height is 0 or null then no possible water to store (base case)
        if(height == null || height.length == 0) {
            return 0;
        }

        //total result of water able to be stored (set initially to 0)
        int result = 0;

        //Left pointer
        int left = 0;

        //Right pointer
        int right = height.length - 1;

        //LeftMax - tracks the highest wall we've seen so far from the left
        int leftMax = height[left];

        //RightMax - tracks the highest wall we've seen so far from the right
        int rightMax = height[right];

        // Loop until the two pointers meet
        while(left < right) {

            // Always move the pointer that has the lower max height
            if(leftMax <= rightMax) {
                
                //Move the left pointer one step to the right if smaller than right (forward)
                left++;


                //Check to see if the current height that the left pointer is pointing at is our new heighest wall or not (if so this is our new leftMax)
                leftMax = Math.max(leftMax, height[left]);

                //Water can only be trapped if current height is less than leftMax (remember current is the one right next to it)
                //leftMax - height[left] gives the trapped water at this position
                result += leftMax - height[left];
            } else {

                // Move the right pointer one step to the left if bigger than left (back)
                right--;

                //Check to see if the current height that the right pointer is pointing at is our new heighest wall or not (if so this is our new rightMax)
                rightMax = Math.max(rightMax, height[right]);

                //Water can only be trapped if current height is less than rightMax
                //rightMax - height[right] gives the trapped water at this position
                result += rightMax - height[right];
            }
        }

        return result;
    }
}
