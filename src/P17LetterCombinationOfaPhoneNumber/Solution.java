package P17LetterCombinationOfaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty())
            return result;
        int[] size = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i < 2) {
                size[i] = 0;
            } else
                size[i] = 3;
            if (i == 7 || i == 9)
                size[i]++;
        }
        char[][] mapping = getCharMapping(size);
        generate(digits, 0, "", mapping, size, result);
        return result;
    }

    void generate(String digits, int index, String current, char[][] mapping, int[] size, List<String> result) {
        char c = digits.charAt(index);
        for (int i = 0; i < size[c - '0']; i++) {
            String newS = current + mapping[c - '0'][i];
            if (index < digits.length() - 1) {
                generate(digits, index + 1, newS, mapping, size, result);
            } else {
                result.add(newS);
            }
        }
    }

    char[][] getCharMapping(int[] size) {
        char c = 'a';
        char[][] mapping = new char[10][4];
        for (int i = 2; i <= 9; i++) {
            for (int j = 0; j < size[i]; j++) {
                mapping[i][j] = c++;
            }
        }
        return mapping;
    }
}