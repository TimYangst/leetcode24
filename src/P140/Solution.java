package P140;

import java.util.ArrayList;
import java.util.List;

class Solution {

    void search(String s, int index, StringBuilder current, List<String> wordDict, List<String> result) {
        if (index == s.length()) {
            result.add(current.toString().trim());
            return;
        }
        int currentLength = current.length();
        for (String word : wordDict) {
            if (index + word.length() <= s.length()
                    && word.equals(s.substring(index, index + word.length()))) {
                search(s, index + word.length(), current.append(word).append(" "), wordDict, result);
                current.setLength(currentLength);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s.length() == 0)
            return List.of("");
        search(s, 0, new StringBuilder(), wordDict, result);
        return result;
    }
}
