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
    boolean find(TreeNode root, TreeNode target, Deque<TreeNode> stack) {
        if (root == null)
            return false;
        stack.addLast(root);
        if (root == target)
            return true;
        if (find(root.left, target, stack))
            return true;
        if (find(root.right, target, stack))
            return true;
        stack.pollLast();
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pStack = new LinkedList<>();
        Deque<TreeNode> qStack = new LinkedList<>();
        if (!find(root, p, pStack))
            return null;
        if (!find(root, q, qStack))
            return null;
        TreeNode result = root;
        while (!pStack.isEmpty() && !qStack.isEmpty() && pStack.peekFirst() == qStack.peekFirst()) {
            result = pStack.pollFirst();
            qStack.pollFirst();
        }
        return result;
    }
}