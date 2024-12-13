package P234;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
};

class Solution1 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        current = head;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length / 2; i++) {
            stack.push(current.val);
            current = current.next;
        }
        if (length % 2 == 1)
            current = current.next;
        while (current != null) {
            if (current.val != stack.pop())
                return false;
            current = current.next;
        }
        return true;
    }
}