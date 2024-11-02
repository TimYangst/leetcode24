package P249;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean isShift(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int delta = s1.charAt(0) - s2.charAt(0);
        if (delta < 0)
            delta += 26;
        for (int i = 1; i < s1.length(); i++) {
            int current = (s1.charAt(i) - s2.charAt(i));
            if (current < 0)
                current += 26;
            if (delta != current)
                return false;
        }
        return true;
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        for (String s : strings) {
            boolean found = false;
            for (List<String> list : result) {
                if (isShift(list.get(0), s)) {
                    found = true;
                    list.add(s);
                    break;
                }
            }
            if (!found) {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                result.add(newList);
            }
        }
        return result;
    }
}
