package Top150.P637AverageofLevelsinBinaryTree;

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if (root == null)
            return result;
        List<Integer> count = new ArrayList<>();
        visit(root, result, count, 0);
        for (int i = 0; i < count.size(); i++) {
            result.set(i, (result.get(i) / count.get(i)));
        }
        return result;
    }

    void visit(TreeNode root, List<Double> result, List<Integer> count, int level) {
        if (root == null)
            return;
        if (level == count.size()) {
            result.add((double) root.val);
            count.add(1);
        } else {
            result.set(level, result.get(level) + root.val);
            count.set(level, count.get(level) + 1);
        }
        visit(root.left, result, count, level + 1);
        visit(root.right, result, count, level + 1);
    }
}