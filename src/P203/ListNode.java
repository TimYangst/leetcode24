package P203;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
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
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val)
            head = head.next;
        if (head == null)
            return head;
        ListNode prev = head;
        while (prev != null && prev.next != null) {
            while (prev.next != null && prev.next.val == val)
                prev.next = prev.next.next;
            prev = prev.next;
        }
        return head;
    }
}
