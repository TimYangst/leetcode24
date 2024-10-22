package P314;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
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

class QNode {
    int index;
    TreeNode tNode;

    public QNode(int index, TreeNode tNode) {
        this.index = index;
        this.tNode = tNode;
    }
}

class Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<QNode> queue = new LinkedList<>();
        queue.add(new QNode(0, root));
        while (!queue.isEmpty()) {
            QNode current = queue.poll();
            map.compute(current.index, (key, value) -> {
                if (value == null)
                    value = new LinkedList<>();
                value.add(current.tNode.val);
                return value;
            });
            if (current.tNode.left != null) {
                queue.add(new QNode(current.index - 1, current.tNode.left));
            }
            if (current.tNode.right != null) {
                queue.add(new QNode(current.index + 1, current.tNode.right));
            }
        }
        for (List<Integer> value : map.values())
            result.add(value);
        return result;
    }
}