package Top150.P290WordPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        int i = 0;
        int j = 0;
        Map<Character, String> cMap = new HashMap<>();
        Set<String> sSet = new HashSet<>();
        while (i < pattern.length() && j < s.length()) {
            char c = pattern.charAt(i);
            i++;
            StringBuilder sb = new StringBuilder();
            while (j < s.length() && 'a' <= s.charAt(j) && 'z' >= s.charAt(j)) {
                sb.append(s.charAt(j));
                j++;
            }
            j++;
            String current = sb.toString();
            if (cMap.containsKey(c)) {
                if (!cMap.get(c).equals(current))
                    return false;
            } else if (!cMap.containsKey(c)) {
                if (sSet.contains(current))
                    return false;
                cMap.put(c, current);
                sSet.add(current);
            }
        }
        if (i < pattern.length() || j < s.length())
            return false;
        return true;
    }
}