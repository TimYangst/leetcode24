package P1249MinimumRemoveToMakeValidParentheses;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> inValid = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    inValid.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            inValid.add(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!inValid.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}