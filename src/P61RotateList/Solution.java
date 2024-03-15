package P61RotateList;

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
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;
        if (head.next == null)
            return head;
        int count = 0;
        ListNode current = head;
        ListNode end = null;
        while (current != null) {
            end = current;
            current = current.next;
            count++;
        }
        if (k % count == 0)
            return head;
        int remains = count - k % count;
        current = head;
        while (remains > 1) {
            current = current.next;
            remains--;
        }
        ListNode result = current.next;
        current.next = null;
        end.next = head;
        return result;
    }
}