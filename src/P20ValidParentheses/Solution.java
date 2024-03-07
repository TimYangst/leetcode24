package P20ValidParentheses;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (!(top == '(' && c == ')' || top == '[' && c == ']' || top == '{' && c == '}'))
                    return false;
            }
            index++;
        }
        return stack.isEmpty();
    }
}