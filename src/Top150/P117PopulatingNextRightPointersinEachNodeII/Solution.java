package Top150.P117PopulatingNextRightPointersinEachNodeII;

/*
// Definition for a Node.
*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

        Map<Integer, Node> nextMap = new HashMap<>();
        connect(1, root.right, nextMap);
        connect(1, root.left, nextMap);
        return root;
    }

    void connect(int level, Node root, Map<Integer, Node> next) {
        if (root == null)
            return;
        if (next.containsKey(level)) {
            root.next = next.get(level);
        }
        next.put(level, root);
        connect(level + 1, root.right, next);
        connect(level + 1, root.left, next);
    }
}
