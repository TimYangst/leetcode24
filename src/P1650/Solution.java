package P1650;

import java.util.HashSet;
import java.util.Set;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        while (a != b) {
            a = (a.parent == null ? q : a.parent);
            b = (b.parent == null ? p : b.parent);
        }
        return a;
    }
}

class Solution1 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> seem = new HashSet<>();
        Node p1 = p;
        Node p2 = q;
        while (p1 != null && p2 != null) {
            if (seem.contains(p1.val))
                return p1;
            seem.add(p1.val);
            if (seem.contains(p2.val))
                return p2;
            seem.add(p2.val);
            p1 = p1.parent;
            p2 = p2.parent;
        }
        while (p1 != null) {
            if (seem.contains(p1.val))
                return p1;
            seem.add(p1.val);
            p1 = p1.parent;
        }
        while (p2 != null) {
            if (seem.contains(p2.val))
                return p2;
            seem.add(p2.val);
            p2 = p2.parent;
        }
        return null;
    }
}