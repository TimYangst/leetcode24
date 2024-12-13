package P236LowestCommonAncestorOfaBinaryTree;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    TreeNode findAny(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root == p || root == q)
            return root;
        TreeNode l = findAny(root.left, p, q);
        TreeNode r = findAny(root.right, p, q);
        if (l != null && r != null)
            return root;
        return l != null ? l : r;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findAny(root, p, q);
    }
}