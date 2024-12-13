package P150EvaluateReversePolishNotation;

import java.util.Set;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operates = Set.of("+", "-", "*", "/");
        int e1, e2;
        for (int i = 0; i < tokens.length; i++) {
            if (operates.contains(tokens[i])) {
                e2 = stack.pop();
                e1 = stack.pop();
                if ("+".equals(tokens[i])) {
                    stack.push(e1 + e2);
                } else if ("-".equals(tokens[i])) {
                    stack.push(e1 - e2);
                } else if ("*".equals(tokens[i])) {
                    stack.push(e1 * e2);
                } else {
                    stack.push((int) (e1 / e2));
                }
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
