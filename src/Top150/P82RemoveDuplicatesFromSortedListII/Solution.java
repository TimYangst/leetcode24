package Top150.P82RemoveDuplicatesFromSortedListII;

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode tmp = new ListNode();
        tmp.next = head;
        ListNode current = tmp;
        while (current.next != null) {
            ListNode next = current.next;
            if (next.next != null && next.val == next.next.val) {
                while (next.next != null && next.next.val == next.val)
                    next = next.next;
                current.next = next.next;
            } else {
                current = next;
            }
        }
        return tmp.next;
    }
}