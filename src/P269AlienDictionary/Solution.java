package P269AlienDictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Dag {
    Map<Character, Node> nodes = new HashMap<>();
    Map<Character, Integer> inCount = new HashMap<>();

    void addNode(char c) {
        nodes.computeIfAbsent(c, key -> new Node(key));
        inCount.computeIfAbsent(c, key -> 0);
    }

    void addEdge(char from, char to) {
        if (nodes.get(from).addNext(to)) {
            inCount.compute(to, (key, value) -> (value + 1));
        }
    }

    String sort() {
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inCount.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);
            Node node = nodes.get(current);
            for (char next : node.next) {
                inCount.compute(next, (key, value) -> (value - 1));
                if (inCount.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        String s = result.toString();
        if (s.length() != nodes.size())
            return "";
        return s;
    }

}

class Node {
    char c;
    Set<Character> next;

    public Node(char c) {
        this.c = c;
        this.next = new HashSet<>();
    }

    boolean addNext(char c) {
        if (this.next.contains(c))
            return false;
        this.next.add(c);
        return true;
    }
}

class TreeNode {
    char c;
    Set<Character> chars;
    List<TreeNode> children;

    public TreeNode(char c) {
        this.c = c;
        this.chars = new HashSet<>();
        this.children = new LinkedList<>();
    }

    public boolean insert(String s, int index, Dag dag) {
        if (s.length() == index) {
            if (chars.size() > 0)
                return false;
            return true;
        }
        char newChar = s.charAt(index);
        dag.addNode(newChar);
        if (chars.contains(newChar)) {
            if (children.getLast().c != newChar)
                return false;
        } else {
            chars.add(newChar);
            TreeNode child = new TreeNode(newChar);
            if (children.size() != 0) {
                dag.addEdge(children.getLast().c, newChar);
            }
            children.add(child);
        }
        return children.getLast().insert(s, index + 1, dag);
    }
}

class Solution {

    public String alienOrder(String[] words) {
        TreeNode root = new TreeNode(' ');
        Dag dag = new Dag();
        for (String word : words) {
            if (!root.insert(word, 0, dag)) {
                return "";
            }
        }
        return dag.sort();
    }
}