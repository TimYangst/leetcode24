package P106ConstructBinaryTreefromInorderPostorderTraversal;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        return buildTree(inorder, postorder, 0, 0, inorder.length);
    }

    TreeNode buildTree(int[] inorder, int[] postorder, int ib, int pb, int l) {
        if (l == 0)
            return null;
        TreeNode result = new TreeNode(postorder[pb + l - 1]);
        if (l == 1)
            return result;
        int j = ib;
        while (inorder[j] != postorder[pb + l - 1])
            j++;
        int ll = j - ib;
        int lr = l - 1 - ll;
        if (ll > 0)
            result.left = buildTree(inorder, postorder, ib, pb, ll);
        if (lr > 0)
            result.right = buildTree(inorder, postorder, j + 1, pb + ll, lr);
        return result;
    }
}