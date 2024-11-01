package P708;

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        } else if (head.next == head) {
            Node n = new Node(insertVal, head);
            head.next = n;
            return head;
        }
        Node previous = head;
        Node current = head.next;
        Node cliff = previous.val > current.val ? head : null;
        while (current != head && !(previous.val <= insertVal && current.val >= insertVal)) {
            previous = current;
            current = current.next;
            if (previous.val > current.val)
                cliff = previous;
        }
        if (cliff == null || (previous.val <= insertVal && current.val >= insertVal)) {
            Node n = new Node(insertVal, current);
            previous.next = n;
            return head;
        } else {
            Node n = new Node(insertVal, cliff.next);
            cliff.next = n;
            return head;
        }
    }
}
