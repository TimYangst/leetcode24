package Top150.P290WordPattern;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        int i = 0;
        int j = 0;
        Map<Character, String> cMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();
        while (i < pattern.length() && j < s.length()) {
            char c = pattern.charAt(i);
            i++;
            while (j < s.length() && s.charAt(j) == ' ')
                j++;
            if (j == s.length())
                return false;
            StringBuilder sb = new StringBuilder();
            while (j < s.length() && 'a' <= s.charAt(j) && 'z' >= s.charAt(j)) {
                sb.append(s.charAt(j));
                j++;
            }
            String current = sb.toString();
            if (cMap.containsKey(c) && sMap.containsKey(current)) {
                if (!cMap.get(c).equals(current) || sMap.get(current) != c)
                    return false;
            } else if (!cMap.containsKey(c) && !sMap.containsKey(current)) {
                cMap.put(c, current);
                sMap.put(current, c);
            } else {
                return false;
            }
        }
        if (i != pattern.length() || j != s.length())
            return false;
        return true;
    }
}