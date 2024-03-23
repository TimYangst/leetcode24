package Top150.P530MinimumAbsoluteDifferenceinBST;

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
    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        int result = Integer.MAX_VALUE;
        TreeNode pre = null;
        Stack<TreeNode> midNodes = new Stack<>();
        TreeNode current = root;
        while (current != null || !midNodes.empty()) {
            if (current == null) {
                current = midNodes.pop();
                if (pre != null) {
                    result = Math.min(result, current.val - pre.val);
                }
                pre = current;
                current = current.right;
            } else {
                midNodes.push(current);
                current = current.left;
            }
        }
        return result;
    }
}