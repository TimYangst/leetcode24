package P13RomanToInteger;

import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> smap = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        if (s.isEmpty())
            return 0;

        int index = s.length() - 1;
        char lastChar = s.charAt(index);
        int result = smap.get(lastChar);
        index--;
        while (index >= 0) {
            char current = s.charAt(index);
            if (smap.get(current) < smap.get(lastChar)) {
                result -= smap.get(current);
            } else {
                result += smap.get(current);
            }
            lastChar = current;
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
