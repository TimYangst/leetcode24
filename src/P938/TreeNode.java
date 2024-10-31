package P938;

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

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        if (low == high) {
            if (root.val == low)
                return root.val;
        }
        if (root.val <= low) {
            if (root.val == low)
                return root.val + rangeSumBST(root.right, low + 1, high);
            else
                return rangeSumBST(root.right, low, high);
        }
        if (root.val >= high) {
            if (root.val == high)
                return root.val + rangeSumBST(root.left, low, high - 1);
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, root.val - 1) + rangeSumBST(root.right, root.val + 1, high);

    }
}