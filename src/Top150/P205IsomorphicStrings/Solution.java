package Top150.P205IsomorphicStrings;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        if (s.length() <= 1)
            return true;
        Map<Character, Character> leftMap = new HashMap<>();
        Map<Character, Character> rightMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (leftMap.containsKey(c1) && rightMap.containsKey(c2)) {
                if (c2 != leftMap.get(c1) || c1 != rightMap.get(c2))
                    return false;
            } else if (!leftMap.containsKey(c1) && !rightMap.containsKey(c2)) {
                leftMap.put(c1, c2);
                rightMap.put(c2, c1);
            } else {
                return false;
            }
        }
        return true;
    }
}