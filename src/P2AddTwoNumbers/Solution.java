package P2AddTwoNumbers;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, previousNode = null;
        ListNode currentNode = null;
        ListNode currentL1Point = l1, currentL2Point = l2;
        int overflow = 0;
        do {
            int currentValue = overflow;
            if (currentL1Point != null) {
                currentValue += currentL1Point.val;
            }
            if (currentL2Point != null) {
                currentValue += currentL2Point.val;
            }
            overflow = (int) currentValue / 10;
            currentValue = currentValue % 10;
            if (result == null) {
                result = new ListNode(currentValue);
                previousNode = result;
                currentNode = result;
            } else {
                previousNode = currentNode;
                currentNode = new ListNode(currentValue);
                previousNode.next = currentNode;
            }
            if (currentL1Point != null) {
                currentL1Point = currentL1Point.next;
            }
            if (currentL2Point != null) {
                currentL2Point = currentL2Point.next;
            }
        } while (currentL1Point != null || currentL2Point != null || overflow != 0);
        return result;
    }
}