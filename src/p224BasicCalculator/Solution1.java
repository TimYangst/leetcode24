package p224BasicCalculator;

import java.util.Map;
import java.util.Stack;

class Solution1 {
    public int calculate(String s) {
        if (s.isEmpty())
            return 0;
        int i = 0;
        int l = s.length();
        boolean opPrevious = true;
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        Map<Character, Integer> opMapping = Map.of('+', 1, '-', 1, '*', 2, '/', 2, '(', 3, ')', 0, '$', 0);

        while (i < l) {
            char c = s.charAt(i);
            i++;
            switch (c) {
                case ' ':
                    continue;
                case '(':
                    opStack.push(c);
                    opPrevious = true;
                    continue;
                case ')': {
                    opPrevious = false;
                    char op = opStack.pop();
                    int value2 = value.pop();
                    int value1;
                    while (op != '(') {
                        value1 = value.pop();
                        value2 = evalute(op, value1, value2);
                        op = opStack.pop();
                    }
                    if (!opStack.isEmpty() && opStack.peek() == 'r') {
                        value.push(-value2);
                        opStack.pop();
                    } else {
                        value.push(value2);
                    }
                    continue;
                }
                case '-': {
                    if (opPrevious) {
                        opPrevious = false;
                        c = s.charAt(i);
                        while (c == ' ') {
                            i++;
                            c = s.charAt(i);
                        }
                        if ('0' <= c && c <= '9') {
                            String number = extractNumber(s, i);
                            value.push(-Integer.valueOf(number));
                            i = i + number.length();
                        } else {
                            opStack.push('r');
                        }
                        continue;
                    }
                } // Pass through.
                case '+':
                case '*':
                case '/': {
                    opPrevious = true;
                    int value2 = value.pop();
                    int value1;
                    while (!opStack.isEmpty() && opMapping.get(opStack.peek()) <= 2
                            && opMapping.get(c) <= opMapping.get(opStack.peek())) {
                        value1 = value.pop();
                        value2 = evalute(opStack.pop(), value1, value2);
                    }
                    value.push(value2);
                    opStack.push(c);
                    continue;
                }
                default: {
                    opPrevious = false;
                    String number = extractNumber(s, i - 1);
                    value.push(Integer.valueOf(number));
                    i = i + number.length() - 1;
                }
            }
        }
        int value2 = value.pop();
        int value1;
        while (!opStack.isEmpty()) {
            value1 = value.pop();
            value2 = evalute(opStack.pop(), value1, value2);
        }
        return value2;
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