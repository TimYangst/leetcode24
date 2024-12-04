package P244;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDistance {
    Map<String, List<Integer>> indexing = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            final int index = i;
            indexing.compute(wordsDict[i], (k, v) -> {
                if (v == null) {
                    v = new ArrayList<Integer>();
                }
                v.add(index);
                return v;
            });
        }

    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = indexing.get(word1);
        List<Integer> l2 = indexing.get(word2);
        int result = Math.abs(l1.get(0) - l2.get(0));
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            int v1 = l1.get(i);
            int v2 = l2.get(j);
            result = Math.min(result, Math.abs(v1 - v2));
            if (v1 < v2)
                i++;
            else
                j++;
        }
        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
