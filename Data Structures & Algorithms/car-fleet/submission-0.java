class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //Stack for the finishing time of the cars
        Stack<Double> stack = new Stack<>();
        int[][] pairs = new int[position.length][2];

        for(int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        //Sort the pairs by position, (largest comes first)
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        //For each pair in pairs
        for(int[] p : pairs) {
            //Calculate the time of current car: (target - position of car (p[0])) / speed of car (p[1])
            double time = ((target - p[0] ) / p[1]);

            //Push the time of current car onto the stack
            stack.push(time);

            //Once the stack has at least 2 cars, we can start comparing.
            /**
                If stack has at least 2 cars AND the time of current car is smaller than or equal to 
                previous car time (can use size of stack minus 2 to get previous car time from stack)
            **/
            if(stack.size() >= 2 && (stack.peek() <= stack.get(stack.size() - 2))) {
                stack.pop();
            }
        }

        //Return the number of times in the stack to get number of fleets
        return stack.size();
    }
}
