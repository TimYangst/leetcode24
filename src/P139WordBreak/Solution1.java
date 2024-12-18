package P139WordBreak;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
    boolean isLeaf = false;
}

class Solution1 {
    private boolean search(String s, int index, int[] f, TrieNode root, TrieNode parent) {
        boolean isStart = root == parent;
        if (index == s.length())
            return isStart;
        char c = s.charAt(index);
        TrieNode current = parent.child.getOrDefault(c, null);
        if (current == null)
            return false;
        if (isStart && f[index] != 0)
            return (f[index] == 1) ? true : false;
        if (current.isLeaf) {
            boolean tryCut = search(s, index + 1, f, root, root);
            if (tryCut) {
                if (isStart) {
                    f[index] = 1;
                }
                return true;
            }
        }
        boolean tryNext = search(s, index + 1, f, root, current);
        if (isStart) {
            f[index] = tryNext ? 1 : -1;
        }
        return tryNext;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0)
            return true;
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current.child.computeIfAbsent(c, k -> new TrieNode());
                current = current.child.get(c);
            }
            current.isLeaf = true;
        }

        int f[] = new int[s.length() + 1];
        f[s.length()] = 1;
        return search(s, 0, f, root, root);
    }
}