package P25ReverseNodesInkGroup;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        ListNode tail = head;
        ListNode result = null;
        int i = k;
        while (tail != null && i > 0) {
            i--;
            result = tail;
            tail = tail.next;
        }
        if (i > 0)
            return head;
        ListNode next = head.next;
        ListNode nextnext = head.next.next;
        ListNode current = head;
        do {
            next.next = current;
            current = next;
            next = nextnext;
            if (nextnext != null)
                nextnext = nextnext.next;
        } while (current != result);
        head.next = reverseKGroup(tail, k);
        return result;
    }
}