package Top150.P222CountCompleteTreeNodes;

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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return countNodes(root, -1, -1);
    }

    int countNodes(TreeNode root, int leftH, int rightH) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.right == null)
            return 2;
        if (leftH == -1)
            leftH = getLeftHight(root.left);
        if (rightH == -1)
            rightH = getRightHight(root.right);
        if (leftH == rightH) {
            return (((1 << leftH) - 1) << 1) + 1;
        }
        int result = 1;
        int leftRightHigh = getRightHight(root.left);
        if (leftH == leftRightHigh) {
            result += (1 << leftH) - 1;
            result += countNodes(root.right, -1, rightH - 1);
            return result;
        } else {
            result += (1 << rightH) - 1;
            result += countNodes(root.left, leftH - 1, leftRightHigh - 1);
            return result;
        }
    }

    int getLeftHight(TreeNode root) {
        if (root == null)
            return 0;
        int result = 0;
        TreeNode current = root;
        while (current != null) {
            result++;
            current = current.left;
        }
        return result;
    }

    int getRightHight(TreeNode root) {
        if (root == null)
            return 0;
        int result = 0;
        TreeNode current = root;
        while (current != null) {
            result++;
            current = current.right;
        }
        return result;
    }
}