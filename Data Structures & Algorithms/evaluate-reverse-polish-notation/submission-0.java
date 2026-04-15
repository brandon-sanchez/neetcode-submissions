class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                //explicitly stating so b comes first in equation
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                //explicitly stating so b is divided by a
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        //Should only be 1 number remaining and that should be answer
        return stack.pop();
    }
}
