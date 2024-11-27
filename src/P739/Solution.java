package P739;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if (temperatures.length <= 1)
            return result;
        Stack<Integer> stack = new Stack<>();
        int i = temperatures.length - 1;
        stack.push(i);
        i--;
        while (i >= 0) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
            i--;
        }
        return result;
    }
}