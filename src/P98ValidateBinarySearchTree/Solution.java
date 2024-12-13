package P98ValidateBinarySearchTree;

import java.util.Stack;

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

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        TreeNode pre = null;
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.empty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                if (pre != null) {
                    if (pre.val >= current.val)
                        return false;
                }
                pre = current;
                current = current.right;
            }
        }
        return true;
    }
}