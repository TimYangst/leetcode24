package P297;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                sb.append(curr.val).append(",");
                queue.add(curr.left);
                queue.add(curr.right);
            } else {
                sb.append("null,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null"))
            return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode();
        root.val = Integer.valueOf(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (!arr[i].equals("null")) {
                TreeNode left = new TreeNode();
                left.val = Integer.valueOf(arr[i]);
                current.left = left;
                queue.add(left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("null")) {
                TreeNode right = new TreeNode();
                right.val = Integer.valueOf(arr[i]);
                current.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));