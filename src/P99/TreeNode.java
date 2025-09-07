package P99;

class Ref {
    TreeNode last = null;
}

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

    TreeNode travel(TreeNode current, Ref ref) {
        if (current.left != null) {
            TreeNode result = travel(current.left, ref);
            if (result != null)
                return result;
        }
        if (ref.last != null && ref.last.val > current.val)
            return ref.last;
        ref.last = current;
        if (current.right != null) {
            return travel(current.right, ref);
        }
        return null;
    }

    TreeNode reverseTravel(TreeNode current, Ref ref) {
        if (current.right != null) {
            TreeNode result = reverseTravel(current.right, ref);
            if (result != null)
                return result;
        }
        if (ref.last != null && ref.last.val < current.val)
            return ref.last;
        ref.last = current;
        if (current.left != null) {
            return reverseTravel(current.left, ref);
        }
        return null;
    }

    public void recoverTree(TreeNode root) {
        TreeNode left = travel(root, new Ref());
        TreeNode right = reverseTravel(root, new Ref());
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
    }
}