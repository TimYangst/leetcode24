package P8StringToInteger;

class Solution {
    public int myAtoi(String s) {
        if (s.isEmpty())
            return 0;
        int result = 0;
        boolean isN = false;
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length())
            return result;
        if (s.charAt(index) == '-') {
            isN = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        while (index < s.length() && isNumber(s.charAt(index))) {
            int pop = s.charAt(index) - '0';
            if (isN) {
                if (result < Integer.MIN_VALUE / 10 ||
                        (result == Integer.MIN_VALUE / 10 && pop > (Integer.MIN_VALUE % 10) * -1)) {
                    result = Integer.MIN_VALUE;
                    return result;
                } else
                    result = result * 10 - pop;
            } else {
                if (result > Integer.MAX_VALUE / 10 ||
                        (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                    result = Integer.MAX_VALUE;
                    return result;
                } else
                    result = result * 10 + pop;
            }
            index++;
        }
        return result;
    }

    boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }
}