package P366;

import java.util.LinkedList;
import java.util.List;

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

    int getHight(TreeNode node, List<List<Integer>> result) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null) {
            if (result.size() == 0) {
                result.add(new LinkedList<>());
            }
            result.get(0).add(node.val);
            return 1;
        }
        int lHight = getHight(node.left, result);
        int rHight = getHight(node.right, result);
        int hight = Math.max(lHight, rHight) + 1;
        if (result.size() < hight) {
            result.add(new LinkedList<>());
        }
        result.get(hight - 1).add(node.val);
        return hight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        getHight(root, result);
        return result;
    }
}