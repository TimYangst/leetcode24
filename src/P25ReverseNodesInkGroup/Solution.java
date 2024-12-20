package P25ReverseNodesInkGroup;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;
        int r = k;
        ListNode next = head;
        ListNode last = null;
        while (r > 0 && next != null) {
            last = next;
            next = next.next;
            r--;
        }
        if (r > 0)
            return head;
        ListNode newHead = head;
        while (newHead != last) {
            ListNode tmp = head.next;
            head.next = head.next.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        head.next = reverseKGroup(next, k);
        return newHead;
    }
}