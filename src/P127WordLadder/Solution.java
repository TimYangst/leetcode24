package P127WordLadder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 0;
        Map<String, Integer> indexing = new HashMap<>();
        indexing.put(beginWord, 0);
        for (String word : wordList) {
            if (!indexing.containsKey(word)) {
                indexing.put(word, indexing.size());
            }
        }
        if (!indexing.containsKey(endWord))
            return 0;
        int n = indexing.size();
        boolean[][] connect = new boolean[n][n];
        for (String s : indexing.keySet()) {
            for (String t : indexing.keySet()) {
                if (isConnect(s, t)) {
                    int i = indexing.get(s);
                    int j = indexing.get(t);
                    connect[i][j] = true;
                    connect[j][i] = true;
                }
            }
        }
        int[] steps = new int[n];
        steps[0] = 1;

        int end = indexing.get(endWord);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty() && steps[end] == 0) {
            int current = queue.poll();
            for (int i = 1; i < n; i++) {
                if (steps[i] == 0 && connect[current][i]) {
                    steps[i] = steps[current] + 1;
                    queue.add(i);
                }
            }
        }
        return steps[end];
    }

    boolean isConnect(String a, String b) {
        int l = a.length();
        int diff = 0;
        for (int i = 0; i < l; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
