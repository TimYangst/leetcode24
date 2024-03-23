package Top150.P141LinkedListCycle;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution1 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        HashSet<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head))
                return true;
            nodeSet.add(head);
            head = head.next;
        }
        return false;
    }
}