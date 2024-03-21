package Top150.P129SumRoottoLeafNumbers;

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

class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return sum(root, 0);
    }

    public int sum(TreeNode root, int top) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return top + root.val;
        if (root.left == null)
            return sum(root.right, (top + root.val) * 10);
        if (root.right == null)
            return sum(root.left, (top + root.val) * 10);
        return sum(root.left, (top + root.val) * 10) + sum(root.right, (top + root.val) * 10);
    }
}