package P138CopyListWithRandomPointer;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node current = head;
        Node newNode;
        while (current != null) {
            newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        Node result = head.next;
        Node rc = result;
        current = head;
        while (current != null) {
            rc = current.next;
            if (current.random != null) {
                rc.random = current.random.next;
            }
            current = rc.next;
        }
        current = head;
        Node previous = current;
        while (current != null) {
            rc = current.next;
            previous = current;
            current = rc.next;
            previous.next = current;
            if (current != null) {
                rc.next = current.next;
                rc = current.next;
            } else
                rc.next = null;
        }
        return result;
    }
}
