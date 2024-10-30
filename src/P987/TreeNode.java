package P987;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

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

class QNode {
    TreeNode node;
    int index;
    int level;

    public QNode(TreeNode node, int index, int level) {
        this.node = node;
        this.index = index;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> visitMap = new TreeMap<>();
        Queue<QNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new QNode(root, 0, 0));
        }
        while (!queue.isEmpty()) {
            QNode current = queue.poll();
            visitMap.compute(current.index, (key, value) -> {
                if (value == null) {
                    value = new TreeMap<>();
                }
                value.compute(current.level, (k, v) -> {
                    if (v == null) {
                        v = new PriorityQueue<>();
                    }
                    v.add(current.node.val);
                    return v;
                });
                return value;
            });
            if (current.node.left != null) {
                queue.add(new QNode(current.node.left, current.index - 1, current.level + 1));
            }
            if (current.node.right != null) {
                queue.add(new QNode(current.node.right, current.index + 1, current.level + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> tMap : visitMap.values()) {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> q : tMap.values()) {
                while (!q.isEmpty()) {
                    list.add(q.poll());
                }
            }
            result.add(list);
        }
        return result;
    }
}