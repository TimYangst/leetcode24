package P141LinkedListCycle;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode oneStep = head.next;
        ListNode twoStep = head.next.next;
        while (twoStep != null) {
            if (oneStep == twoStep) {
                return true;
            }
            oneStep = oneStep.next;
            if (twoStep.next == null)
                return false;
            twoStep = twoStep.next.next;
        }
        return false;
    }
}
