package P93;

import java.util.LinkedList;
import java.util.List;

class Solution {
    boolean isValid(String s, int i, int j) {
        if (i == j)
            return true;
        if (j - i + 1 > 3)
            return false;
        if (s.charAt(i) == '0')
            return false;
        return Integer.valueOf(s.substring(i, j + 1)) <= 255;
    }

    void search(String s, int b, int l, String current, List<String> result) {
        if (b + (4 - l) > s.length())
            return;
        for (int i = 1; i <= 3; i++) {
            if (b + i < s.length() && isValid(s, b, b + i - 1)) {
                if (l == 2) {
                    if (isValid(s, b + i, s.length() - 1)) {
                        result.add(current + s.substring(b, b + i) + '.' + s.substring(b + i));
                    }
                } else {
                    search(s, b + i, l + 1, current + s.substring(b, b + i) + '.', result);
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12)
            return new LinkedList<>();
        List<String> result = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            if (isValid(s, 0, i)) {
                search(s, i + 1, 1, s.substring(0, i + 1) + '.', result);
            } else
                break;
        }
        return result;
    }
}