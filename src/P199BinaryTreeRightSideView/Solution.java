package P199BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        visit(root, 0, result);
        return result;
    }

    void visit(TreeNode root, int level, List<Integer> result) {
        if (root == null)
            return;
        if (level >= result.size()) {
            result.add(root.val);
        }
        visit(root.right, level + 1, result);
        visit(root.left, level + 1, result);
    }
}