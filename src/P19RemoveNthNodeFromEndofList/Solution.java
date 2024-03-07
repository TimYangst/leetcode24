package P19RemoveNthNodeFromEndofList;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode current = head, previous = null;
        current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        int i = (length - n + 1);
        if (i == 1)
            return head.next;
        current = head;
        while (i > 1) {
            i--;
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return head;
    }
}