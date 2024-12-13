package P102BinaryTreeLevelOrderTraversal;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        visit(root, 0, result);
        return result;
    }

    void visit(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (result.size() <= level) {
            List<Integer> newList = new ArrayList<Integer>();
            newList.add(root.val);
            result.add(newList);
        } else {
            result.get(level).add(root.val);
        }
        visit(root.left, level + 1, result);
        visit(root.right, level + 1, result);
    }
}