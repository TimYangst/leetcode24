package P282;

import java.util.ArrayList;
import java.util.List;

class Solution {
    void search(String num, int index, String express, long preValue, long lastValue, boolean plusAhead, int target,
            List<String> result) {
        long evaluated = (plusAhead == true ? preValue + lastValue : preValue - lastValue);
        if (index == num.length()) {
            if (evaluated == target) {
                result.add(express);
            }
            return;
        }
        int j = num.length();
        if (num.charAt(index) == '0')
            j = index + 1;
        for (int i = index + 1; i <= j; i++) {
            long current = Long.valueOf(num.substring(index, i));
            // +
            search(num, i, express + "+" + current, evaluated,
                    current, true, target, result);
            // -
            search(num, i, express + "-" + current, evaluated,
                    current, false, target, result);
            // *
            search(num, i, express + "*" + current, preValue,
                    lastValue * current, plusAhead, target, result);
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num.length() == 1) {
            if (Integer.valueOf(num) == target) {
                result.add(num);
            }
            return result;
        }
        if (num.charAt(0) == '0') {
            search(num, 1, "" + num.charAt(0), 0, num.charAt(0) - '0', true, target, result);
        } else {
            for (int i = 1; i <= num.length(); i++) {
                search(num, i, num.substring(0, i), 0,
                        Long.valueOf(num.substring(0, i)), true, target, result);
            }
        }
        return result;
    }
}