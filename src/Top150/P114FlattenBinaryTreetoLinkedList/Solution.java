package Top150.P114FlattenBinaryTreetoLinkedList;

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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null) {
            flatten(root.right);
            return;
        }
        if (root.right == null) {
            flatten(root.left);
            root.right = root.left;
            root.left = null;
            return;
        }
        flatten(root.left);
        TreeNode leftRight = root.left;
        while (leftRight.right != null) {
            leftRight = leftRight.right;
        }
        flatten(root.right);
        leftRight.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}