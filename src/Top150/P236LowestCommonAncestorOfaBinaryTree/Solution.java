package Top150.P236LowestCommonAncestorOfaBinaryTree;

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
    class Found {
        boolean findP = false;
        boolean findQ = false;
        TreeNode result;

        boolean allFound() {
            return findP && findQ;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root == p || root == q)
            return root;
        Found found = searchNodes(root, p, q);
        return found.result;
    }

    Found searchNodes(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return new Found();
        Found lResult = searchNodes(root.left, p, q);
        if (lResult.allFound())
            return lResult;
        Found rResult = searchNodes(root.right, p, q);
        if (rResult.allFound())
            return rResult;
        Found result = new Found();
        if (root == p) {
            result.findP = true;
        } else if (root == q) {
            result.findQ = true;
        }
        result.findP = result.findP || lResult.findP || rResult.findP;
        result.findQ = result.findQ || lResult.findQ || rResult.findQ;
        result.result = root;

        return result;
    }
}