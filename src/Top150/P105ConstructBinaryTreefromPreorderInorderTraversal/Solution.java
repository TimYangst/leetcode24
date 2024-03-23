package Top150.P105ConstructBinaryTreefromPreorderInorderTraversal;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        return buildTree(preorder, inorder, 0, 0, preorder.length);
    }

    TreeNode buildTree(int[] preorder, int[] inorder, int pb, int ib, int l) {
        if (l == 0)
            return null;
        if (l == 1) {
            return new TreeNode(preorder[pb]);
        }
        TreeNode result = new TreeNode(preorder[pb]);
        int j = ib;
        while (inorder[j] != preorder[pb])
            j++;
        int ll = j - ib;
        int lr = l - 1 - ll;
        if (ll > 0) {
            result.left = buildTree(preorder, inorder, pb + 1, ib, ll);
        }
        if (lr > 0) {
            result.right = buildTree(preorder, inorder, pb + 1 + ll, j + 1, lr);
        }
        return result;
    }
}