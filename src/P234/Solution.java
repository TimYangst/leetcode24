package P234;

class Solution {

    ListNode reverse(ListNode head) {
        ListNode next = head;
        ListNode current = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = current;
            current = next;
            next = tmp;
        }
        return current;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversed = reverse(slow);
        while (reversed != null) {
            if (head.val != reversed.val)
                return false;
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }
}