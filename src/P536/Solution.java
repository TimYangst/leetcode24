package P536;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private void addChild(TreeNode p, TreeNode c) {
        if (p.left == null)
            p.left = c;
        else
            p.right = c;
    }

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0)
            return null;
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();
        do {
            int b = i;
            while (i < s.length() && (s.charAt(i) == '-'
                    || s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                i++;
            int value = Integer.valueOf(s.substring(b, i));
            TreeNode node = new TreeNode(value);
            node.left = null;
            node.right = null;
            stack.push(node);
            if (i >= s.length())
                break;
            while (i < s.length() && s.charAt(i) == ')') {
                TreeNode child = stack.pop();
                addChild(stack.peek(), child);
                i++;
            }
            if (i >= s.length())
                break;
            if (s.charAt(i) == '(') {
                i++;
            }
        } while (i < s.length());
        return stack.pop();
    }
}