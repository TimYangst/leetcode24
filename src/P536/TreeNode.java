package P536;

/**
 * Definition for a binary tree node.
 */

public class TreeNode {
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

class ReturnResult {
    TreeNode node;
    int lastIndex;

    ReturnResult(TreeNode node, int lastIndex) {
        this.node = node;
        this.lastIndex = lastIndex;
    }
}

class Solution {
    private ReturnResult buildTree(String s, int index) {
        int i = index;
        while (i < s.length() &&
                (s.charAt(i) == '-' || '0' <= s.charAt(i) && '9' >= s.charAt(i)))
            i++;
        int value = Integer.valueOf(s.substring(index, i));
        TreeNode node = new TreeNode(value);
        node.left = null;
        node.right = null;
        ReturnResult result = new ReturnResult(node, i);
        if (i >= s.length() || s.charAt(i) == ')')
            return result;
        if (s.charAt(i) == '(') {
            ReturnResult leftResult = buildTree(s, i + 1);
            node.left = leftResult.node;
            result.lastIndex = leftResult.lastIndex + 1;
            if (result.lastIndex + 1 < s.length()
                    && s.charAt(leftResult.lastIndex + 1) == '(') {
                ReturnResult rightResult = buildTree(s, leftResult.lastIndex + 2);
                node.right = rightResult.node;
                result.lastIndex = rightResult.lastIndex + 1;
            }
        }
        return result;
    }

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0)
            return null;
        return buildTree(s, 0).node;
    }
}
