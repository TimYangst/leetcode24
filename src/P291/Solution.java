package P291;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    private boolean search(String pattern, int pI, String s, int sI, Map<Character, String> map, Set<String> rSet) {
        if (pI >= pattern.length() || sI >= s.length()) {
            if (pI == pattern.length() && sI == s.length())
                return true;
            return false;
        }
        char c = pattern.charAt(pI);
        if (map.containsKey(c)) {
            String mapped = map.get(c);
            if (s.substring(sI).startsWith(mapped)) {
                return search(pattern, pI + 1, s, sI + mapped.length(), map, rSet);
            } else
                return false;
        } else {
            for (int i = sI + 1; i <= s.length(); i++) {
                String mapped = s.substring(sI, i);
                if (!rSet.contains(mapped)) {
                    map.put(c, mapped);
                    rSet.add(mapped);
                    if (search(pattern, pI + 1, s, i, map, rSet))
                        return true;
                    map.remove(c);
                    rSet.remove(mapped);
                }
            }
        }
        return false;
    }

    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> rSet = new HashSet<>();
        return search(pattern, 0, s, 0, map, rSet);
    }
}