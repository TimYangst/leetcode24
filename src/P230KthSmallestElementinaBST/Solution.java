package P230KthSmallestElementinaBST;

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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (k > 0) {
            if (current == null) {
                current = stack.pop();
                k--;
                if (k == 0)
                    return current.val;
                current = current.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }
        return 0;
    }
}