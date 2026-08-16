class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        //have the minVal pushed into the stack till the current value
        // if minStack is empty then the current is already minimum
        if(minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        int top = stack.peek();
        return top;
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
