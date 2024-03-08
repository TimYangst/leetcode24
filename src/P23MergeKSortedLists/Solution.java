package P23MergeKSortedLists;

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        return merge(lists, 0, lists.length - 1);
    }

    ListNode merge(ListNode[] lists, int b, int e) {
        if (b == e)
            return lists[b];
        if (b + 1 == e)
            return twoMerge(lists[b], lists[e]);
        int m = (b + e) / 2;
        return twoMerge(merge(lists, b, m), merge(lists, m + 1, e));
    }

    ListNode twoMerge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode result = null;
        ListNode current = null;
        if (l1.val <= l2.val) {
            result = l1;
            l1 = l1.next;
        } else {
            result = l2;
            l2 = l2.next;
        }
        current = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null)
            current.next = l2;
        else
            current.next = l1;
        return result;
    }
}