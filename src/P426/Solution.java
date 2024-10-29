package P426;

/*
// Definition for a Node.*/
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        Node leftList = null;
        Node rightList = null;

        if (root.left != null) {
            leftList = treeToDoublyList(root.left);
        }
        if (root.right != null) {
            rightList = treeToDoublyList(root.right);
        }
        Node result = null;
        if (leftList == null) {
            result = root;
            root.left = root;
            root.right = root;
        } else {
            Node tail = leftList.left;
            leftList.left = root;
            root.left = tail;
            tail.right = root;
            root.right = leftList;
            result = leftList;
        }
        if (rightList != null) {
            Node tail = result.left;
            result.left = rightList.left;
            rightList.left.right = result;
            tail.right = rightList;
            rightList.left = tail;
        }
        return result;
    }
}