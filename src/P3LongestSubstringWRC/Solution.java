package P3LongestSubstringWRC;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int result = 0;
        int lastCut = -1;
        for (int index = 0; index < s.length(); index++) {
            int previous = -1;
            if (charIndex.containsKey(s.charAt(index))) {
                previous = charIndex.get(s.charAt(index));
            }
            if (previous > lastCut) {
                lastCut = previous;
            }
            if (index - lastCut > result) {
                result = index - lastCut;
            }
            charIndex.put(s.charAt(index), index);
        }
        return result;
    }
}