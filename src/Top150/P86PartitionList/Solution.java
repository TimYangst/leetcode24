package Top150.P86PartitionList;

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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode();
        ListNode preSmall = small;
        ListNode big = new ListNode();
        ListNode preBig = big;
        ListNode current = head;
        while (current != null) {
            if (current.val >= x) {
                preBig.next = current;
                preBig = current;
            } else {
                preSmall.next = current;
                preSmall = current;
            }
            current = current.next;
            preBig.next = null;
            preSmall.next = null;
        }
        preSmall.next = big.next;
        return small.next;
    }
}