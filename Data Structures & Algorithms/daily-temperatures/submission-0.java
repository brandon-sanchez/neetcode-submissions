class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] output = new int[temperatures.length];
        
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && (temperatures[i] > temperatures[stack.peek()])) {
                int prevIndex = stack.pop();
                int numDaysWaited = i - prevIndex;
                output[prevIndex] = numDaysWaited;
            }
            stack.push(i);
        }

        return output;
    }
}
