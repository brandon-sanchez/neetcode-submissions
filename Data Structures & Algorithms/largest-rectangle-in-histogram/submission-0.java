class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); //pair: (index, height)

        // Traverse the list of heights
        for(int i = 0; i < heights.length; i++) {
            //Set start to be i;
            int start = i;

            //While the stack is not empty AND the height at the top of the stack (within the pair of index, height) is greater than the current height
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                // pop from the top of the stack and set the index and height to be that of what was popped from the pair in the stack
                int top[] = stack.pop();
                int index = top[0];
                int height = top[1];

                //Then compare the current maxArea with the new Area (what was popped from the stack) and take the max of the two
                maxArea = Math.max(maxArea, height * (i - index));

                //Then set the start to be the index that was popped
                start = index;
            }

            // Otherwise, keep adding to the stack since the current height is bigger then what's at the top of the stack
            stack.push(new int[] {start, heights[i]});
        }


        // Iterate through the pairs in the stack
        for(int[] pair : stack) {

            //Set the index and height to be the pair
            int index = pair[0];
            int height = pair[1];

            //Check to see if any of the pairs in the stack are bigger than the currentMax area from the things that were already popped from the stack
            //Compare the two and take the biggest
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        //Return the maxArea
        return maxArea;
    }
}
