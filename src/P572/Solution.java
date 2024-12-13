package P572;

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

    private boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.val == root2.val
                && sameTree(root1.left, root2.left)
                && sameTree(root1.right, root2.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null)
            return true;
        if (root == null)
            return false;
        if (root.val == subRoot.val) {
            if (sameTree(root, subRoot))
                return true;
        }
        if (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)) {
            return true;
        }
        return false;
    }
}