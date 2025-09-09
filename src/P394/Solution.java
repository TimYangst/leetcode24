package P394;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                strStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int count = countStack.pop();
                StringBuilder prev = strStack.pop();
                for (int i = 0; i < count; i++) {
                    prev.append(current);
                }
                current = prev;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}