class MinStack {
    private Stack<Integer> normalStack;
    private Stack<Integer> currentMinStack;

    public MinStack() {
        normalStack = new Stack<>();
        currentMinStack = new Stack<>();
    }
    
    public void push(int val) {
        normalStack.push(val);
        if(currentMinStack.isEmpty() || val <= currentMinStack.peek()) {
            currentMinStack.push(val);
        }
    }
    
    public void pop() {
        if(normalStack.isEmpty()) {
            return;
        }

        if(normalStack.pop() == currentMinStack.peek()){
            currentMinStack.pop();
        } 

    }
    
    public int top() {
        return normalStack.peek();
    }
    
    public int getMin() {
        return currentMinStack.peek();
    }
}
