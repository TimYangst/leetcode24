package P863;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    void getKDepthChildren(TreeNode root, int k, List<Integer> result) {
        if (root == null)
            return;
        if (k == 0) {
            result.add(root.val);
            return;
        }
        getKDepthChildren(root.left, k - 1, result);
        getKDepthChildren(root.right, k - 1, result);
    }

    int seekKDistance(TreeNode root, TreeNode target, int k, List<Integer> result) {
        if (root == null)
            return -1;
        // k > 0;
        if (target == root) {
            getKDepthChildren(root.left, k - 1, result);
            getKDepthChildren(root.right, k - 1, result);
            return 0;
        } else {
            int left = seekKDistance(root.left, target, k, result);
            if (left != -1) {
                if (left + 1 == k) {
                    result.add(root.val);
                } else if (left + 1 < k) {
                    getKDepthChildren(root.right, k - left - 2, result);
                }
                return left + 1;
            }
            int right = seekKDistance(root.right, target, k, result);
            if (right != -1) {
                if (right + 1 == k) {
                    result.add(root.val);
                } else if (right + 1 < k) {
                    getKDepthChildren(root.left, k - right - 2, result);
                }
                return right + 1;
            }
            return -1;
        }
    }

    boolean findNode(TreeNode root, TreeNode target, List<Integer> result) {
        if (root == null)
            return false;
        if (root == target) {
            result.add(root.val);
            return true;
        }
        if (!findNode(root.left, target, result)) {
            return findNode(root.right, target, result);
        }
        return true;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            findNode(root, target, result);
        } else {
            seekKDistance(root, target, k, result);
        }
        return result;
    }
}