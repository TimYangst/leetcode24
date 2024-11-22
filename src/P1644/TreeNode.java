package P1644;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int count = 0;

    TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        TreeNode l = find(root.left, p, q);
        TreeNode r = find(root.right, p, q);
        if (root == p || root == q) {
            count++;
            return root;
        }
        if (l != null && r != null)
            return root;
        return l != null ? l : r;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = find(root, p, q);
        if (count < 2)
            return null;
        return result;
    }
}