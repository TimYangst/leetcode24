package P320;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<String> generateAbbreviations(String word) {
        List<String>[] result = (List<String>[]) new List[word.length() + 1];
        result[0] = new ArrayList<>();
        result[1] = new ArrayList<>(List.of("1", word.substring(0, 1)));

        for (int i = 2; i <= word.length(); i++) {
            result[i] = new ArrayList<>();
            result[i].add(String.valueOf(i));
            char c = word.charAt(i - 1);
            for (String s : result[i - 1]) {
                result[i].add(s + c);
            }
            for (int j = 1; j <= i - 1; j++) {
                for (String s : result[i - j]) {
                    if (Character.isLetter(s.charAt(s.length() - 1))) {
                        result[i].add(s + j);
                    }
                }
            }
        }
        return result[word.length()];

    }
}