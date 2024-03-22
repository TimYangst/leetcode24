package Top150.P173BinarySearchTreeIterator;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    class ListNode {
        TreeNode node;
        ListNode next;
    }

    ListNode head, current;

    public BSTIterator(TreeNode root) {
        head = new ListNode();
        current = head;
        buildList(root, head);
    }

    public int next() {
        current = current.next;
        return current.node.val;
    }

    public boolean hasNext() {
        return current.next != null;
    }

    ListNode buildList(TreeNode root, ListNode previous) {
        if (root == null)
            return previous;
        if (root.left != null) {
            previous = buildList(root.left, previous);
        }
        ListNode current = new ListNode();
        current.node = root;
        previous.next = current;
        previous = current;
        if (root.right != null) {
            previous = buildList(root.right, current);
        }
        return previous;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
