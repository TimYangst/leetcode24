package P17LetterCombinationOfaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private char[][] getMapping() {
        char[][] mapping = new char[10][];
        char c = 'a';
        for (int i = 0; i < 10; i++) {
            if (i < 2)
                mapping[i] = new char[0];
            else if (i != 7 && i != 9) {
                mapping[i] = new char[3];
            } else {
                mapping[i] = new char[4];
            }
            for (int j = 0; j < mapping[i].length; j++)
                mapping[i][j] = c++;
        }
        return mapping;
    }

    public List<String> letterCombinations(String digits) {
        List<String> current = new ArrayList<>();
        if (digits.isEmpty())
            return current;
        char[][] mapping = getMapping();
        current.add(digits);
        for (int i = 0; i < digits.length(); i++) {
            List<String> next = new ArrayList<>();
            for (String str : current) {
                char[] arr = str.toCharArray();
                int index = arr[i] - '0';
                for (char c : mapping[index]) {
                    arr[i] = c;
                    next.add(new String(arr));
                }
            }
            current = next;
        }
        return current;
    }
}
