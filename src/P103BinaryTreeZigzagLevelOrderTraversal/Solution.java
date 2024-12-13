package P103BinaryTreeZigzagLevelOrderTraversal;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        visit(root, 0, false, 0, result);
        visit(root, 0, true, 1, result);
        return result;
    }

    void visit(TreeNode root, int level, boolean rightFirst, int mod, List<List<Integer>> result) {
        if (root == null)
            return;
        if (result.size() <= level) {
            result.add(new ArrayList<Integer>());
        }
        if (level % 2 == mod) {
            result.get(level).add(root.val);
        }
        if (rightFirst) {
            visit(root.right, level + 1, rightFirst, mod, result);
            visit(root.left, level + 1, rightFirst, mod, result);
        } else {
            visit(root.left, level + 1, rightFirst, mod, result);
            visit(root.right, level + 1, rightFirst, mod, result);
        }
    }
}