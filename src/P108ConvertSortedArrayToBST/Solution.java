package P108ConvertSortedArrayToBST;

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
    TreeNode buildBST(int[] nums, int b, int length) {
        if (length <= 0)
            return null;
        int mid = b + length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, b, mid - b);
        root.right = buildBST(nums, mid + 1, length - (mid - b) - 1);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return buildBST(nums, 0, nums.length);
    }
}