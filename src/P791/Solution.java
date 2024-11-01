package P791;

import java.util.Arrays;

class Solution {
    public String customSortString(String order, String s) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++)
            index[order.charAt(i) - 'a'] = i;

        Character[] cArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cArray[i] = s.charAt(i);
        }
        Arrays.sort(cArray, (a, b) -> (index[a - 'a'] - index[b - 'a']));
        StringBuilder sb = new StringBuilder();
        for (Character c : cArray) {
            sb.append(c);
        }
        return sb.toString();
    }
}