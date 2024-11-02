package P1047;

import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            Character c = s.charAt(i);
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else
                stack.pop();
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}