package P139WordBreak;

import java.util.List;

class Solution {
    private boolean search(String s, int index, int[] f, List<String> wordDict) {
        int remains = s.length() - index;
        if (remains < 0)
            return false;
        if (f[index] != 0)
            return (f[index] == 1) ? true : false;
        for (String word : wordDict) {
            if (word.length() == 0 || word.length() > remains)
                continue;
            if (s.substring(index, index + word.length()).equals(word)) {
                boolean isMatched = search(s, index + word.length(), f, wordDict);
                if (isMatched) {
                    f[index] = 1;
                    return true;
                }
            }
        }
        f[index] = -1;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0)
            return true;
        int f[] = new int[s.length() + 1];
        f[s.length()] = 1;
        return search(s, 0, f, wordDict);
    }
}