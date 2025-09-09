package P143;

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
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        int ct = 0;
        int size = stack.size();
        ListNode current = head;
        ListNode next = head.next;
        while (ct < (size - 1) / 2) {
            ListNode last = stack.pop();
            stack.peek().next = null;
            current.next = last;
            last.next = next;
            next = next.next;
            current = last.next;
            ct++;
        }
    }
}