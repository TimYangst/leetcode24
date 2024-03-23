package Top150.p224BasicCalculator;

import java.util.Map;
import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if (s.isEmpty())
            return 0;
        int i = 0;
        int l = s.length();
        boolean opPrevious = true;
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        Map<Character, Integer> opMapping = Map.of('+', 0, '-', 0, '*', 1, '/', 1, '(', 2, ')', 3, '$', 4, 'r', 5);
        int[][] opCompare = new int[][] {
                { -1, -1, 1, 0, 1, 1 },
                { 1, -1, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 1, 1 },
                { -1, -1, 1, 0, 0, 0 },
                { -1, -1, 0, 0, 1, 0 } };

        char c;
        opStack.push('$');
        while (i <= l) {
            if (i == l) {
                c = '$';
            } else
                c = s.charAt(i);
            i++;
            if (c == ' ')
                continue;
            else if ('0' <= c && c <= '9') {
                opPrevious = false;
                String number = extractNumber(s, i - 1);
                i = i + number.length() - 1;
                if (!opStack.isEmpty() && opStack.peek() == 'r') {
                    opStack.pop();
                    valueStack.push(-Integer.valueOf(number));
                } else
                    valueStack.push(Integer.valueOf(number));
                continue;
            } else if (c == '-' && opPrevious) {
                opStack.push('r');
                opPrevious = false;
                continue;
            } else {
                int value1;
                int value2;
                while (opCompare[opMapping.get(c)][opMapping.get(opStack.peek())] < 0) {
                    value2 = valueStack.pop();
                    value1 = valueStack.pop();
                    valueStack.push(evalute(opStack.pop(), value1, value2));
                }
                if (c == ')') {
                    opPrevious = false;
                    opStack.pop();
                    if (opStack.peek() == 'r') {
                        opStack.pop();
                        value2 = valueStack.pop();
                        valueStack.push(-value2);
                    }
                    continue;
                } else {
                    opPrevious = true;
                    opStack.push(c);
                }
            }
        }
        return valueStack.pop();
    }

    String extractNumber(String s, int b) {
        int l = s.length();
        int i = b;
        while (i < l && ('0' <= s.charAt(i) && s.charAt(i) <= '9')) {
            i++;
        }
        return s.substring(b, i);
    }

    int evalute(char op, int value1, int value2) {
        switch (op) {
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            case '*':
                return value1 * value2;
            case '/':
                return value1 / value2;
        }
        return 0;
    }
}