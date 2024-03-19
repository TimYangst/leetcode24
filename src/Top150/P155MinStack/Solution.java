package Top150.P155MinStack;

class MinStack {

    private static final int MAXL = 30001;

    private int[] stack;
    private int[] minStack;

    public MinStack() {
        stack = new int[MAXL + 2];
        minStack = new int[MAXL + 2];
    }

    public void push(int val) {
        stack[0]++;
        stack[stack[0]] = val;
        if (minStack[0] == 0 || val <= minStack[minStack[0]]) {
            minStack[0]++;
            minStack[minStack[0]] = val;
        }
    }

    public void pop() {
        int top = stack[stack[0]--];
        if (top == minStack[minStack[0]])
            minStack[0]--;
    }

    public int top() {
        return stack[stack[0]];
    }

    public int getMin() {
        return minStack[minStack[0]];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */