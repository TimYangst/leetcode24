package P876;

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
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null) {
            fast = fast.next;
            if (fast == null)
                break;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}