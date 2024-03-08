package P25ReverseNodesInkGroup;

import java.util.Stack;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        ListNode tail = head;
        int i = k;
        Stack<ListNode> stack = new Stack<>();
        while (tail != null && i > 0) {
            i--;
            stack.push(tail);
            tail = tail.next;
        }
        if (i > 0)
            return head;
        ListNode result = stack.pop();
        ListNode current = result;
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        current.next = reverseKGroup(tail, k);
        return result;
    }
}