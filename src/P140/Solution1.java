package P140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
    boolean isLeaf = false;
}

class Solution1 {
    private TrieNode buildTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String s : wordDict) {
            TrieNode current = root;
            for (char c : s.toCharArray()) {
                current.child.computeIfAbsent(c, k -> new TrieNode());
                current = current.child.get(c);
            }
            current.isLeaf = true;
        }
        return root;
    }

    void search(String s, int index, StringBuilder current, TrieNode root, TrieNode parent,
            List<String> result) {
        boolean isStart = root == parent;
        if (index == s.length()) {
            if (isStart) {
                current.setLength(current.length() - 1);
                result.add(current.toString());
            }
            return;
        }
        TrieNode currentNode = parent.child.getOrDefault(s.charAt(index), null);
        if (currentNode == null)
            return;
        current.append(s.charAt(index));
        int currentLength = current.length();
        if (currentNode.isLeaf) {
            current.append(" ");
            search(s, index + 1, current, root, root, result);
            current.setLength(currentLength);
        }
        search(s, index + 1, current, root, currentNode, result);
        current.setLength(currentLength - 1);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s.length() == 0)
            return List.of("");
        TrieNode root = buildTrie(wordDict);
        search(s, 0, new StringBuilder(), root, root, result);
        return result;
    }
}