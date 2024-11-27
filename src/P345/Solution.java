package P345;

import java.util.Stack;

class Solution {

    boolean isVowel(char l) {

        return l == 'a' || l == 'e' || l == 'u' || l == 'i' || l == 'o'
                || l == 'A' || l == 'I' || l == 'E' || l == 'U' || l == 'O';
    }

    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!isVowel(s.charAt(i))) {
                result.append(s.charAt(i));
            } else {
                result.append(stack.pop());
            }
        }
        return result.toString();
    }
}