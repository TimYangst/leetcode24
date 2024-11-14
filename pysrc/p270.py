# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        if root is None:
            return -1
        result = root.val
        if target < root.val and root.left is not None:
            leftValue = self.closestValue(root.left, target)
            if (abs(target - leftValue) <= result - target):
                result = leftValue
        elif target > root.val and root.right is not None:
            rightValue = self.closestValue(root.right, target)
            if target - result > abs(rightValue - target):
                result = rightValue
        return result