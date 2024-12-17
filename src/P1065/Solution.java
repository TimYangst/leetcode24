package P1065;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] child;
    boolean isLeaf;

    TrieNode() {
        child = new TrieNode[26];
        isLeaf = false;
    }
}

class Solution {
    public int[][] indexPairs(String text, String[] words) {
        if (words.length == 0)
            return new int[0][];
        List<int[]> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        int maxL = words[0].length();
        int minL = words[0].length();
        for (String word : words) {
            maxL = Math.max(maxL, word.length());
            minL = Math.min(minL, word.length());
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.child[c - 'a'] == null) {
                    current.child[c - 'a'] = new TrieNode();
                }
                current = current.child[c - 'a'];
            }
            current.isLeaf = true;
        }
        for (int i = 0; i + minL <= text.length(); i++) {
            TrieNode current = root;
            for (int j = 0; j < maxL && i + j < text.length(); j++) {
                char c = text.charAt(i + j);
                if (current.child[c - 'a'] == null)
                    break;
                else {
                    current = current.child[c - 'a'];
                    if (current == null)
                        break;
                    if (current.isLeaf)
                        result.add(new int[] { i, i + j });
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}