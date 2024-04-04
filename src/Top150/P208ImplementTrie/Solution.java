package Top150.P208ImplementTrie;
import java.util.HashMap;
import java.util.Map;

class Trie {
    class Node {
        Map<Character, Node> children = new HashMap<>(); 
        boolean isLeaf = false; 
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        insert(word, root);
    }
    
    public boolean search(String word) {
        return search(word, root);
    }
    
    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    void insert(String word, Node node) {
        if (word == null || word.isEmpty()) {
            node.isLeaf = true; 
        } else {
            char c = word.charAt(0);
            Node child; 
            if (node.children.containsKey(c)) {
                child = node.children.get(c);
            } else {
                child = new Node();
                node.children.put(c, child);
            }
            insert(word.substring(1), child);
        }
    }

    boolean search(String word, Node node) {
        if (word == null || word.isEmpty()) {
            return node.isLeaf;
        }
        char c = word.charAt(0);
        if (!node.children.containsKey(c)) return false;
        return search(word.substring(1), node.children.get(c));
    }

    boolean startsWith(String word, Node node) {
        if (word == null || word.isEmpty()) {
            return node.isLeaf || node.children.size() > 0;
        }
        char c = word.charAt(0);
        if (!node.children.containsKey(c)) return false;
        return startsWith(word.substring(1), node.children.get(c));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
