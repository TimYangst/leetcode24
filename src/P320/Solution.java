package P320;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private void dfs(int index, String word, int count, StringBuilder current, List<String> result) {
        int len = current.length();
        if (index == word.length()) {
            if (count > 0) {
                current.append(count);
            }
            result.add(current.toString());
        } else {
            dfs(index + 1, word, count + 1, current, result);
            if (count != 0)
                current.append(count);
            current.append(word.charAt(index));
            dfs(index + 1, word, 0, current, result);
        }
        current.setLength(len);
    }

    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        dfs(0, word, 0, new StringBuilder(), result);
        return result;
    }
}