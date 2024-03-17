package Contest.P1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isSubstringPresent(String s) {
        if (s.length() < 2)
            return false;
        int length = s.length();
        Set<String> strMap = new HashSet<>();

        for (int i = 0; i < length - 1; i++) {
            strMap.add(s.substring(i, i + 2));
        }
        for (int i = length - 1; i > 0; i--) {
            StringBuilder current = new StringBuilder();
            current.append(s.charAt(i)).append(s.charAt(i - 1));
            if (strMap.contains(current.toString()))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubstringPresent("edocteel"));
    }
}