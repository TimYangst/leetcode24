package P227;

import java.util.Stack;

class ReturnedNumber {
    int value;
    int next;

    public ReturnedNumber(int value, int next) {
        this.value = value;
        this.next = next;
    }
}

class Solution {
    private boolean isNumberOrSpace(char c) {
        return c == ' ' || ('0' <= c && c <= '9');
    }

    private ReturnedNumber getNumber(String s, int index) {
        int value = 0;
        int i = index;
        while (i < s.length() && isNumberOrSpace(s.charAt(i))) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            value = value * 10 + (s.charAt(i) - '0');
            i++;
        }
        return new ReturnedNumber(value, i);
    }

    private boolean isLowPriority(char next, char previous) {
        if (previous == '$')
            return false;
        if (next == '$')
            return true;
        if (next == '+' || next == '-')
            return true;
        if (previous == '/' || previous == '*')
            return true;
        return false;
    }

    private int calc(char op, int previous, int current) {
        switch (op) {
            case '*':
                return previous * current;
            case '/':
                return previous / current;
            case '+':
                return previous + current;
            case '-':
                return previous - current;
            default:
                return 0;
        }
    }

    private void evaluate(char op, Stack<Integer> numbers, Stack<Character> ops) {
        int current = numbers.pop();
        while (isLowPriority(op, ops.peek())) {
            char top = ops.pop();
            int previous = numbers.pop();
            current = calc(top, previous, current);
        }
        numbers.push(current);
        ops.push(op);
    }

    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();
        ops.push('$');
        int i = 0;
        ReturnedNumber num = getNumber(s, i);
        i = num.next;
        numbers.push(num.value);
        while (i < s.length()) {
            char op = s.charAt(i);
            i++;
            evaluate(op, numbers, ops);
            num = getNumber(s, i);
            i = num.next;
            numbers.push(num.value);
        }
        evaluate('$', numbers, ops);
        return numbers.pop();
    }
}