package Top150.P124BinaryTreeMaximumPathSum;

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

    class NodeInfo {
        int maxSubPath;
        int maxToRoot;
    }

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        NodeInfo info = searchMaxPath(root);
        return info.maxSubPath;
    }

    NodeInfo searchMaxPath(TreeNode root) {
        NodeInfo result = new NodeInfo();
        if (root.left == null && root.right == null) {
            result.maxSubPath = root.val;
            result.maxToRoot = root.val;
            return result;
        }
        NodeInfo rightInfo;
        NodeInfo leftInfo;
        if (root.left == null) {
            rightInfo = searchMaxPath(root.right);
            result.maxToRoot = Math.max(rightInfo.maxToRoot + root.val, root.val);
            result.maxSubPath = Math.max(rightInfo.maxSubPath, result.maxToRoot);
            return result;
        }
        if (root.right == null) {
            leftInfo = searchMaxPath(root.left);
            result.maxToRoot = Math.max(leftInfo.maxToRoot + root.val, root.val);
            result.maxSubPath = Math.max(leftInfo.maxSubPath, result.maxToRoot);
            return result;
        }
        rightInfo = searchMaxPath(root.right);
        leftInfo = searchMaxPath(root.left);
        result.maxToRoot = Math.max(root.val, Math.max(leftInfo.maxToRoot, rightInfo.maxToRoot) + root.val);
        result.maxSubPath = Math.max(leftInfo.maxSubPath, rightInfo.maxSubPath);
        int midPath = root.val;
        if (leftInfo.maxToRoot > 0)
            midPath += leftInfo.maxToRoot;
        if (rightInfo.maxToRoot > 0)
            midPath += rightInfo.maxToRoot;
        result.maxSubPath = Math.max(result.maxSubPath, midPath);
        return result;
    }
}
