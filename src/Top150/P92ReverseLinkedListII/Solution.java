package Top150.P92ReverseLinkedListII;

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode current = tmp;
        ListNode previous = tmp;
        ListNode tail, reversed;
        for (int i = 0; i < left; i++) {
            previous = current;
            current = current.next;
        }
        tail = current;
        reversed = current;
        previous.next = current.next;
        for (int i = left; i < right; i++) {
            ListNode p = previous.next;
            previous.next = p.next;
            p.next = reversed;
            reversed = p;
        }
        tail.next = previous.next;
        previous.next = reversed;
        return tmp.next;
    }
}